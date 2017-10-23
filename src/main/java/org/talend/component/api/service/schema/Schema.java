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
package org.talend.component.api.service.schema;

import java.util.Collection;

import org.talend.component.api.meta.Partial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Partial("This API should support nested schema but the Studio is not yet ready.\n\nThe cloud platform also doesn't use it yet.")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schema {

    private Collection<Entry> entries;

    // todo: add private Map<String, Entry> nestedSchemas; when studio will support it
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Entry {

        private String name;

        private Type type;
    }
}
