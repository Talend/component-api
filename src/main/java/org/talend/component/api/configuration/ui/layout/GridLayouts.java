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
package org.talend.component.api.configuration.ui.layout;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.ui.meta.Ui;
import org.talend.component.api.meta.Documentation;

/**
 * Just a java 8 wrapper to support multiple {@link GridLayout} on the same model.
 */
@Ui
@Documentation("Allow to configure multiple grid layouts on the same class, qualified with a classifier (name)")
@Target(TYPE)
@Retention(RUNTIME)
public @interface GridLayouts {
    GridLayout[] value();
}
