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
import org.talend.component.api.service.completion.DynamicValues;

@ActionRef(DynamicValues.class)
@Documentation("Mark the decorated field as supporting dynamic value filling (depending the server state and not known at component coding time).")
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface Proposable {

    /**
     * @return value of @{@link DynamicValues} value method.
     */
    String value();
}
