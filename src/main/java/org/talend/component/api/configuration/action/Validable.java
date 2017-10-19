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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.action.meta.ActionRef;
import org.talend.component.api.meta.Documentation;
import org.talend.component.api.service.asyncvalidation.AsyncValidation;

@ActionRef(AsyncValidation.class)
@Documentation("Mark the decorated field/parameter as supporting dropdown completion. Server expects the client "
        + "to pass the parameter value as parameter. It can optionally have other parameters but they must match the "
        + "form/parameter parameter path exactly then to let the client fill them.")
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface Validable {

    /**
     * @return value of @{@link org.talend.component.api.service.asyncvalidation.AsyncValidation} value method.
     */
    String value();

    /**
     * This "list" will represent the parameter the caller will send to the validation.
     * Assuming you have this validation:
     *
     * {@code @AsyncValidation("xxx") ValidationResult doValidate(@Option("value") String value, @Option("other") String other)}
     *
     * And this model:
     *
     * {@code public class MyModel { @Validable(value = "xxx", parameters = {".", "foo"}) @Option String something; @Option String foo; }}
     *
     * This must call doValidate(something, foo).
     *
     * Syntax is the following:
     *
     * <ul>
     *     <li>.: represents the decorated option (aka "this")</li>
     *     <li>../foo: represents the <pre>foo</pre> option of the parent (if exists) of "."</li>
     *     <li>bar: represents the <pre>bar</pre> sibling option of the decorated field</li>
     *     <li>bar/dummy: represents the <pre>dummy</pre> option of the child bar of the decorated field</li>
     * </ul>
     *
     * This syntax is close to path syntax but the important point is all the parameters are related to the decorated option.
     *
     * @return parameters for the validation.
     */
    String[] parameters() default {"."};
}
