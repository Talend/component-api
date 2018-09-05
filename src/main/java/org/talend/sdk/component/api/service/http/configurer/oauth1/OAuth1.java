/**
 * Copyright (C) 2006-2018 Talend Inc. - www.talend.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.talend.sdk.component.api.service.http.configurer.oauth1;

import static java.util.Locale.ROOT;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.talend.sdk.component.api.service.http.Configurer;

import lombok.Builder;
import lombok.Data;

public class OAuth1 implements Configurer {

    @Override
    public void configure(final Connection connection, final ConfigurerConfiguration configuration) {
        final Configuration oauth1Config = Stream.of(configuration.configuration()).filter(Configuration.class::isInstance)
                .findFirst().map(Configuration.class::cast)
                .orElseThrow(() -> new IllegalArgumentException("No OAuth1.Configuration @ConfigurerOption set"));

        final Map<String, String> values = buildParameters(connection.getMethod(), connection.getUrl(), connection.getPayload(),
                oauth1Config);

        final String authorization = ofNullable(oauth1Config.getHeaderPrefix()).orElse("OAuth ")
                + values.entrySet().stream().filter(e -> e.getKey().startsWith("oauth_"))
                        .map(e -> e.getKey() + "=\"" + e.getValue() + "\"").collect(joining(", "));
        connection.withHeader(ofNullable(oauth1Config.getHeader()).orElse("Authorization"), authorization);
    }

    public Map<String, String> buildParameters(final String method, final String url, final byte[] payload,
            final OAuth1.Configuration oauth1Config) {
        final String algorithm = ofNullable(oauth1Config.getAlgorithm()).orElse("HMAC-SHA1");
        final Map<String, String> values = new TreeMap<>();
        values.put("oauth_consumer_key", oauth1Config.getConsumerKey());
        values.put("oauth_nonce", ofNullable(oauth1Config.getNonce()).orElseGet(this::newNonce));
        values.put("oauth_signature_method", algorithm);
        values.put("oauth_timestamp", ofNullable(oauth1Config.getTimestamp()).map(String::valueOf)
                .orElseGet(() -> Long.toString(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()))));
        values.put("oauth_version", "1.0");
        ofNullable(oauth1Config.getToken()).ifPresent(token -> values.put("oauth_token", token));
        ofNullable(oauth1Config.getPayloadHashAlgorithm())
                .ifPresent(algo -> values.put("oauth_body_hash", hash(algo, ofNullable(payload).orElseGet(() -> new byte[0]))));
        values.entrySet().forEach(e -> e.setValue(encode(e.getValue())));

        final String signature = sign(algorithm, signingString(values, method, url), oauth1Config);
        values.put("oauth_signature", signature);
        return values;
    }

    private String hash(final String algo, final byte[] payload) {
        try {
            final MessageDigest digest = MessageDigest.getInstance(algo);
            return Base64.getEncoder().encodeToString(digest.digest(payload));
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid hashing computation using algorithm: " + algo, e);
        }
    }

    private String sign(final String algorithm, final String signingString, final Configuration configuration) {
        if (algorithm.toLowerCase(ROOT).contains("hmac")) {
            final byte[] signingKey = ofNullable(configuration.getSigningHmacKey())
                    .orElseGet(() -> Stream.of(configuration.getConsumerSecret(), configuration.getTokenSecret())
                            .filter(Objects::nonNull).map(this::encode).collect(joining("&")).getBytes(StandardCharsets.UTF_8));
            try {
                final SecretKeySpec key = new SecretKeySpec(signingKey, algorithm);
                final Mac mac = Mac.getInstance(key.getAlgorithm().replace("-", ""));
                mac.init(key);
                return encode(Base64.getEncoder().encodeToString(mac.doFinal(signingString.getBytes(StandardCharsets.UTF_8))));
            } catch (final InvalidKeyException | NoSuchAlgorithmException e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                final Signature signature = Signature.getInstance(algorithm.replace("-", ""));
                signature.initSign(configuration.getSigningSignatureKey());
                signature.update(signingString.getBytes(StandardCharsets.UTF_8));
                return encode(Base64.getEncoder().encodeToString(signature.sign()));
            } catch (final SignatureException | InvalidKeyException | NoSuchAlgorithmException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private String signingString(final Map<String, String> values, final String method, final String url) {
        return method.toUpperCase(ROOT) + "&" + encode(stripQuery(url)) + "&" + encode(
                values.entrySet().stream().map(e -> String.format("%s=%s", e.getKey(), e.getValue())).collect(joining("&")));
    }

    private String stripQuery(final String url) {
        if (url.contains("?")) {
            return url.substring(0, url.indexOf('?'));
        }
        return url;
    }

    private String encode(final String value) {
        try {
            return URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (final UnsupportedEncodingException uee) {
            throw new IllegalStateException(uee.getMessage(), uee);
        }
    }

    private String newNonce() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Data
    @Builder
    public static class Configuration {

        /**
         * The header name to set, by default it uses Authorization.
         */
        private String header;

        /**
         * The prefix to preppend to the header value, by default it uses "OAuth".
         */
        private String headerPrefix;

        /**
         * The payload hashing algorithm, default to null (ignored).
         */
        private String payloadHashAlgorithm;

        /**
         * The signing algorithm, default to HmacSHA1.
         */
        private String algorithm;

        /**
         * When using a hmac algorithm the key, if null default one is composed based on consumer key and token secret.
         */
        private byte[] signingHmacKey;

        /**
         * When using a signature algorithm the private key to use.
         */
        private PrivateKey signingSignatureKey;

        /**
         * Additional oauth parameters (not encoded).
         */
        private Map<String, String> oauthParameters;

        /**
         * oauth_token if set, otherwise ignored.
         */
        private String token;

        /**
         * OAuth token secret.
         */
        private String tokenSecret;

        /**
         * OAuth consumer key.
         */
        private String consumerKey;

        /**
         * OAuth consumer secret.
         */
        private String consumerSecret;

        /**
         * The nonce to use if set, otherwise it is generated.
         */
        private String nonce;

        /**
         * The timestamp to use if set, otherwise it is generated.
         */
        private Long timestamp;
    }
}
