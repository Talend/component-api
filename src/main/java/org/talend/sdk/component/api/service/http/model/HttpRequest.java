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
package org.talend.sdk.component.api.service.http.model;

import java.util.Map;

import org.talend.sdk.component.api.service.http.Configurer;

public interface HttpRequest {

    /**
     * @return the path of the http request
     */
    String getRequestPath();

    /**
     * @return HTTP request method type (GET, POST, PUT ...)
     */
    String getMethodType();

    /**
     * @return list of the http request query params
     */
    Map<String, String> getQueryParams();

    /**
     * @return list of the http request header
     */
    Map<String, String> getHeaders();

    /**
     * @return true if the request contains a payload that need to be sent
     */
    boolean hasPayLoad();

    /**
     * @return the http request body data
     */
    byte[] getBody();

    /**
     * @return return the http request configurer instance.
     */
    Configurer getConfigurer();

    /**
     * @return options for the configurer returned by {@link #getConfigurer()}
     */
    Configurer.ConfigurerConfiguration getConfigurationOptions();
}
