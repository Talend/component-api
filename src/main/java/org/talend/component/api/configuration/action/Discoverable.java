// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.component.api.configuration.action;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.action.meta.ActionRef;
import org.talend.component.api.meta.Documentation;
import org.talend.component.api.service.schema.DiscoverSchema;

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
