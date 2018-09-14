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
package org.talend.sdk.component.api.record;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;

public interface Record {

    /**
     * @return the schema of this record.
     */
    Schema getSchema();

    /**
     * Access a record field value.
     *
     * @param expectedType the expected type for the column.
     * @param name the name of the column.
     * @param <T> the type of expectedType.
     * @return the column value.
     */
    <T> T get(Class<T> expectedType, String name);

    default String getString(final String name) {
        return get(String.class, name);
    }

    default int getInt(final String name) {
        return get(Integer.class, name);
    }

    default long getLong(final String name) {
        return get(Long.class, name);
    }

    default double getDouble(final String name) {
        return get(Double.class, name);
    }

    default float getFloat(final String name) {
        return get(Float.class, name);
    }

    default boolean getBoolean(final String name) {
        return get(Boolean.class, name);
    }

    default byte[] getBytes(final String name) {
        return get(byte[].class, name);
    }

    default Record getRecord(final String name) {
        return get(Record.class, name);
    }

    default <T> Collection<T> getArray(final Class<T> type, final String name) {
        return get(Collection.class, name);
    }

    default ZonedDateTime getDateTime(final String name) {
        return get(ZonedDateTime.class, name);
    }

    /**
     * Allows to create a record with a fluent API. This is the unique recommended way to create a record.
     */
    interface Builder {

        Record build();

        Builder withString(String name, String value);

        Builder withString(Schema.Entry entry, String value);

        Builder withBytes(String name, byte[] value);

        Builder withBytes(Schema.Entry entry, byte[] value);

        Builder withDateTime(String name, Date value);

        Builder withDateTime(Schema.Entry entry, Date value);

        Builder withDateTime(String name, ZonedDateTime value);

        Builder withDateTime(Schema.Entry entry, ZonedDateTime value);

        Builder withTimestamp(String name, long value);

        Builder withTimestamp(Schema.Entry entry, long value);

        Builder withInt(String name, int value);

        Builder withInt(Schema.Entry entry, int value);

        Builder withLong(String name, long value);

        Builder withLong(Schema.Entry entry, long value);

        Builder withFloat(String name, float value);

        Builder withFloat(Schema.Entry entry, float value);

        Builder withDouble(String name, double value);

        Builder withDouble(Schema.Entry entry, double value);

        Builder withBoolean(String name, boolean value);

        Builder withBoolean(Schema.Entry entry, boolean value);

        Builder withRecord(Schema.Entry entry, Record value);

        <T> Builder withArray(Schema.Entry entry, Collection<T> values);
    }
}
