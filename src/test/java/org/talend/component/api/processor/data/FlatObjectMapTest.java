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

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.Test;

public class FlatObjectMapTest {

    private final ObjectMap map = new FlatObjectMap(new HashMap<String, Object>() {

        {
            put("a", 1);
            put("b", "second");
        }
    });

    @Test
    public void get() {
        assertEquals(1, map.get("a"));
        assertEquals("second", map.get("b"));
    }

    @Test
    public void keys() {
        assertEquals(Stream.of("a", "b").collect(toSet()), map.keys());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getMap() {
        map.getMap("a");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getCollection() {
        map.getCollection("a");
    }
}
