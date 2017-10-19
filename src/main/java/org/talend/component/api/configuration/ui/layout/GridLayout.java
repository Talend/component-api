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

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.component.api.configuration.ui.meta.Ui;
import org.talend.component.api.meta.Documentation;

@Ui
@Documentation("Advanced layout to place properties by row, this is exclusive with `@OptionsOrder`.")
@Target(TYPE)
@Retention(RUNTIME)
@Repeatable(GridLayouts.class)
public @interface GridLayout {

    interface FormType {

        String MAIN = "Main";

        String ADVANCED = "Advanced";

        @Deprecated // this one means nothing, surely to drop and use main instead
        String CITIZEN = "CitizenUser";
    }

    /**
     * @return the ordered list of rows of the layout.
     */
    Row[] value();

    /**
     * @return the form name associated to this definition.
     */
    String[] names() default FormType.MAIN;

    /**
     * Defines a UI row (list of widgets).
     */
    @Target(PARAMETER)
    @Retention(RUNTIME)
    @interface Row {

        /**
         * @return the ordered list of property/widgets to set on this row.
         */
        String[] value();
    }
}
