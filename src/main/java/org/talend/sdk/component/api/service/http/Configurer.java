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
package org.talend.sdk.component.api.service.http;

import java.net.HttpURLConnection;

/**
 * Callback to configure the connection more deeply. Typically used to configure timeouts.
 */
public interface Configurer {

    /**
     * @param connection the current connection to customize.
     * @param configuration the configuration of the invocation if any.
     */
    void configure(HttpURLConnection connection, ConfigurerConfiguration configuration);

    /**
     * Represents the potential {@link ConfigurerOption} parameters of the invocation.
     */
    interface ConfigurerConfiguration {

        /**
         * @return all options at once.
         */
        Object[] configuration();

        /**
         * @param name the option name.
         * @param type the expected type of the option.
         * @param <T> the type of the option.
         * @return the option value or null if missing.
         */
        <T> T get(String name, Class<T> type);
    }
}
