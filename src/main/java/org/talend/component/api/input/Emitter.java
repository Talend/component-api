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
package org.talend.component.api.input;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Mark a class as returning an input connector.
 * This is only useful when there is no {@link PartitionMapper}.
 */
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
public @interface Emitter {

    /**
     * @return the family of this mapper (family/grouping value).
     */
    String family() default "";

    /**
     * @return the value of the input.
     */
    String name() default "";
}
