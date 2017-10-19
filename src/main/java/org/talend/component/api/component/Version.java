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
package org.talend.component.api.component;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.meta.Documentation;

@Documentation("Set the component version and optionally a way to migrate the incoming configuration on the fly.")
@Target(TYPE)
@Retention(RUNTIME)
public @interface Version {

    /**
     * @return the current version of the component.
     */
    int value() default 1;

    /**
     * @return the handler able ot migrate properties from one version to another one.
     */
    Class<? extends MigrationHandler> migrationHandler() default MigrationHandler.class;
}
