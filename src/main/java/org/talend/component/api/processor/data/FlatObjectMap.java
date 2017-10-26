/**
 * Copyright (C) 2006-2017 Talend Inc. - www.talend.com
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
package org.talend.component.api.processor.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * A default {@link ObjectMap} implementation usable for flat data structures.
 *
 * IMPORTANT: it doesn't support nested objects or collections.
 */
@ToString
@AllArgsConstructor
public class FlatObjectMap implements ObjectMap, Serializable {

    private final Map<String, Object> values;

    @Override
    public Object get(final String location) {
        return values.get(location);
    }

    @Override
    public Set<String> keys() {
        return values.keySet();
    }

    @Override
    public ObjectMap getMap(final String location) {
        throw new UnsupportedOperationException("unsupported nested objects");
    }

    @Override
    public Collection<ObjectMap> getCollection(final String location) {
        throw new UnsupportedOperationException("unsupported nested collections");
    }
}
