/**
 *  Copyright (C) 2006-2017 Talend Inc. - www.talend.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.talend.component.api.configuration.action;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.action.meta.ActionRef;
import org.talend.component.api.meta.Documentation;
import org.talend.component.api.meta.Partial;
import org.talend.component.api.service.schema.DiscoverSchema;

@Partial("See Schema description.")
@ActionRef(DiscoverSchema.class)
@Documentation("Mark the decorated as supporting schema discovery. Since the model can be different from the schema model, the binding "
        + "method allows to associate either the whole returned schema, keys or types depending if binding is ALL, KEYS or TYPES. The decorated option "
        + " must therefore have the corresponding type (Schema, List<String>, List<String>/List<Type>).")
@Target(TYPE)
@Retention(RUNTIME)
public @interface Discoverable {

    /**
     * @return value of @{@link org.talend.component.api.service.schema.DiscoverSchema} value method.
     */
    String value() default "default";

    /**
     * @return references the extracted property from the output which will be bound to this value.
     */
    Binding binding() default Binding.KEYS;

    enum Binding {
        ALL,
        KEYS,
        TYPES
    }
}
