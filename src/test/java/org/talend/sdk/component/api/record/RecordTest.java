/**
 * Copyright (C) 2006-2019 Talend Inc. - www.talend.com
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
package org.talend.sdk.component.api.record;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import org.junit.Test;

import lombok.RequiredArgsConstructor;

public class RecordTest {

    @Test
    public void optionalString() {
        final Optional<String> opt = new MockRecord("ok").getOptionalString("dd");
        assertTrue(opt.isPresent());
        assertEquals("ok", opt.orElseThrow(IllegalStateException::new));
    }

    @Test
    public void optionalArray() {
        final List<String> value = asList("a", "b");
        final Optional<Collection<String>> opt = new MockRecord(value).getOptionalArray(String.class, "ddd");
        assertTrue(opt.isPresent());
        assertEquals(value, opt.orElseThrow(IllegalStateException::new));
    }

    @Test
    public void optionalDate() {
        final ZonedDateTime value = ZonedDateTime.now();
        final Optional<ZonedDateTime> opt = new MockRecord(value).getOptionalDateTime("ddd");
        assertTrue(opt.isPresent());
        assertEquals(value, opt.orElseThrow(IllegalStateException::new));
    }

    @Test
    public void optionalLong() {
        final long value = 1L;
        final OptionalLong opt = new MockRecord(value).getOptionalLong("ddd");
        assertTrue(opt.isPresent());
        assertEquals(value, opt.orElseThrow(IllegalStateException::new));
    }

    @RequiredArgsConstructor
    private static class MockRecord implements Record {

        private final Object value;

        @Override
        public Schema getSchema() {
            return null;
        }

        @Override
        public <T> T get(final Class<T> expectedType, final String name) {
            return expectedType.cast(value);
        }
    }
}
