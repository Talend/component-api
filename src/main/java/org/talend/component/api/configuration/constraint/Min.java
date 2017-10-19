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
package org.talend.component.api.configuration.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Collection;

import org.talend.component.api.configuration.constraint.meta.Validation;
import org.talend.component.api.meta.Documentation;

@Validation(expectedTypes = { Number.class, int.class, short.class, byte.class, long.class, double.class,
        float.class }, name = "min")
@Validation(expectedTypes = Collection.class, name = "minItems")
@Validation(expectedTypes = CharSequence.class, name = "minLength")
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Documentation("Ensure the decorated option size is validated with a lower bound.")
public @interface Min {

    double value();
}
