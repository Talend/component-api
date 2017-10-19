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
package org.talend.component.api.service.schema;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.meta.Documentation;
import org.talend.component.api.service.ActionType;

/**
 * Mark a method as retruning the {@link Schema} of a dataset. The only configuration
 * parameter will be an {@link org.talend.component.api.configuration.Option} named "dataset".
 */
@ActionType(value = "schema", expectedReturnedType = Schema.class)
@Target(METHOD)
@Retention(RUNTIME)
@Documentation("Mark an action as returning a discovered schema. Its parameter MUST be the type decorated with `@Discoverable`.")
public @interface DiscoverSchema {
    /**
     * @return the component family this action belongs to.
     */
    String family() default "";

    /**
     * @return the identifier usable by {@link org.talend.component.api.configuration.action.Discoverable}
     * to reference this action.
     */
    String value() default "default";
}
