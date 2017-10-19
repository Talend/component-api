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
package org.talend.component.api.configuration.condition;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.condition.meta.Condition;
import org.talend.component.api.meta.Documentation;

@Documentation("If the evaluation of the element at the location matches value then the element is considered active, "
        + "otherwise it is deactivated.")
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Condition("if")
public @interface ActiveIf {

    String target();

    String[] value();
}
