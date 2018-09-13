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
package org.talend.sdk.component.api.service.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.talend.sdk.component.api.meta.Partial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Partial("This API should support nested schema but the Studio is not yet ready.\n\n"
        + "The cloud platform also doesn't use it yet.\n\nAlso prefer to use "
        + "`org.talend.sdk.component.api.record.Schema` over this partial default implementation.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Deprecated // use SchemaBuilder instead of this implementation
public class Schema implements org.talend.sdk.component.api.record.Schema {

    private List<org.talend.sdk.component.api.record.Schema.Entry> entries;

    // 1.0 compat
    public Schema(final Collection<org.talend.sdk.component.api.record.Schema.Entry> entries) {
        this.entries = new ArrayList<>(entries);
    }

    // 1.0 compat
    public void setEntries(final Collection<org.talend.sdk.component.api.record.Schema.Entry> entries) {
        this.entries = new ArrayList<>(entries);
    }

    @Override
    public Type getType() {
        return Type.RECORD;
    }

    @Override
    public org.talend.sdk.component.api.record.Schema getElementSchema() {
        return null;
    }

    @Override
    public <T> T unwrap(final Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Deprecated
    public static class Entry implements org.talend.sdk.component.api.record.Schema.Entry {

        private String name;

        private Schema.Type type;

        // 1.0 compat
        public Entry(final String name, final org.talend.sdk.component.api.service.schema.Type type) {
            this.name = name;
            this.type = org.talend.sdk.component.api.record.Schema.Type.valueOf(type.name());
        }

        // 1.0 compat
        public void setType(final org.talend.sdk.component.api.service.schema.Type type) {
            this.type = org.talend.sdk.component.api.record.Schema.Type.valueOf(type.name());
        }

        @Override
        public boolean isNullable() {
            return true;
        }

        @Override
        public <T> T getDefaultValue() {
            return null;
        }

        @Override
        public org.talend.sdk.component.api.record.Schema getElementSchema() {
            return null;
        }

        @Override
        public String getComment() {
            return null;
        }
    }
}
