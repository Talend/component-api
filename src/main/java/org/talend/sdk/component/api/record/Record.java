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

import static java.util.Optional.ofNullable;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface Record {

    /**
     * @return the schema of this record.
     */
    Schema getSchema();

    /**
     * Access a record field value.
     *
     * IMPORTANT: it is always better to use the typed accessors and the optional flavor when the entry is nullable.
     *
     * @param expectedType the expected type for the column.
     * @param name the name of the column.
     * @param <T> the type of expectedType.
     * @return the column value.
     */
    <T> T get(Class<T> expectedType, String name);

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default String getString(final String name) {
        return get(String.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default int getInt(final String name) {
        return get(Integer.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default long getLong(final String name) {
        return get(Long.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default double getDouble(final String name) {
        return get(Double.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default float getFloat(final String name) {
        return get(Float.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default boolean getBoolean(final String name) {
        return get(Boolean.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default byte[] getBytes(final String name) {
        return get(byte[].class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default Record getRecord(final String name) {
        return get(Record.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param type type of the elements of the collection.
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default <T> Collection<T> getArray(final Class<T> type, final String name) {
        return get(Collection.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default ZonedDateTime getDateTime(final String name) {
        return get(ZonedDateTime.class, name);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param type type of the elements of the collection.
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default <T> Optional<Collection<T>> getOptionalArray(final Class<T> type, final String name) {
        final Collection<T> value = get(Collection.class, name);
        return ofNullable(value);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default Optional<ZonedDateTime> getOptionalDateTime(final String name) {
        return ofNullable(get(ZonedDateTime.class, name));
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default Optional<String> getOptionalString(final String name) {
        return ofNullable(get(String.class, name));
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default OptionalInt getOptionalInt(final String name) {
        final Integer value = get(Integer.class, name);
        return value == null ? OptionalInt.empty() : OptionalInt.of(value);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default OptionalLong getOptionalLong(final String name) {
        final Long value = get(Long.class, name);
        return value == null ? OptionalLong.empty() : OptionalLong.of(value);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default OptionalDouble getOptionalDouble(final String name) {
        final Double value = get(Double.class, name);
        return value == null ? OptionalDouble.empty() : OptionalDouble.of(value);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default OptionalDouble getOptionalFloat(final String name) {
        final Float value = get(Float.class, name);
        return value == null ? OptionalDouble.empty() : OptionalDouble.of(value);
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default Optional<Boolean> getOptionalBoolean(final String name) {
        return ofNullable(get(Boolean.class, name));
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default Optional<byte[]> getOptionalBytes(final String name) {
        return ofNullable(get(byte[].class, name));
    }

    /**
     * See {@link Record#get(Class, String)}.
     * 
     * @param name entry name.
     * @return the value of the entry in this record.
     */
    default Optional<Record> getOptionalRecord(final String name) {
        return ofNullable(get(Record.class, name));
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
