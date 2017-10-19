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
package org.talend.component.api.service.asyncvalidation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.meta.Documentation;
import org.talend.component.api.service.ActionType;

@ActionType(value = "validation", expectedReturnedType = ValidationResult.class)
@Target(METHOD)
@Retention(RUNTIME)
@Documentation("Mark a method as being used to validate a configuration. IMPORTANT: this is a server validation "
        + "so only use it if you can't use other client side validation to implement it.")
public @interface AsyncValidation {

    /**
     * @return the value of the component family this action relates to.
     */
    String family() default "";

    /**
     * @return an identifier matched with
     * {@link org.talend.component.api.configuration.action.Validable}.
     */
    String value();
}
