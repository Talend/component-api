/**
 * Copyright (C) 2006-2018 Talend Inc. - www.talend.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.talend.sdk.component.api.service.http;

import org.talend.sdk.component.api.service.http.model.HttpRequest;

/**
 * You can cast an injected client with this type to initialize the base.
 */
public interface HttpClient {

    /**
     * set the base URI of the http request
     *
     * @param base the base URI of the http client
     */
    void base(String base);

    /**
     * Execute an http request
     *
     * @param httpRequest http request definition
     * @return a http client ready to be used.
     */
    @Request
    Response<byte[]> execute(HttpRequest httpRequest);
}
