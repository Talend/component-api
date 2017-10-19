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
package org.talend.component.api.service.healthcheck;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.meta.Documentation;
import org.talend.component.api.service.ActionType;
import org.talend.component.api.service.schema.Schema;

/**
 * Mark a method as retruning the {@link HealthCheckStatus} of a datastore. The only configuration
 * parameter will be an {@link org.talend.component.api.configuration.Option} named "datastore"
 * and matching the @DataStore property.
 */
@ActionType(value = "healthcheck", expectedReturnedType = HealthCheckStatus.class)
@Target(METHOD)
@Retention(RUNTIME)
@Documentation("This class marks an action doing a connection test")
public @interface HealthCheck {

    /**
     * @return the value of the component family this action relates to.
     */
    String family() default "";

    /**
     * @return the value of the action.
     */
    String value() default "default";
}
