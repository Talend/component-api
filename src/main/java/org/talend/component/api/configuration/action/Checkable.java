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
import org.talend.component.api.service.healthcheck.HealthCheck;

@ActionRef(HealthCheck.class)
@Documentation("Mark the decorated type/model as testable with a health check action.")
@Target(TYPE)
@Retention(RUNTIME)
public @interface Checkable {

    /**
     * @return value of @{@link HealthCheck} method form this component family health checks.
     */
    String value() default "default";
}
