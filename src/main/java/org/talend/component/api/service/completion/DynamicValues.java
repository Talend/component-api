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
package org.talend.component.api.service.completion;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.action.Proposable;
import org.talend.component.api.meta.Documentation;
import org.talend.component.api.service.ActionType;

@ActionType(value = "dynamic_values", expectedReturnedType = Values.class)
@Target(METHOD)
@Retention(RUNTIME)
@Documentation("Mark a method as being useful to fill potential values of a string option "
        + "for a property denoted by its value. "
        + "You can link a field as being completable using @Proposable(value). The resolution of the completion action "
        + "is then done through the component family and value of the action. The callback doesn't take any parameter.")
public @interface DynamicValues {

    /**
     * @return the value of the component family this action relates to.
     */
    String family() default "";

    /**
     * @return an identifier usable by
     * {@link Proposable}
     * to reference this method.
     */
    String value();
}
