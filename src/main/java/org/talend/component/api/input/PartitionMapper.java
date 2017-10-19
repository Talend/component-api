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

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
public @interface PartitionMapper {

    /**
     * @return the component of this mapper (family/grouping value).
     */
    String family() default "";

    /**
     * @return the value of the related input.
     */
    String name() default "";

    /**
     * If the @Producer method of the underlying {@see Emitter} can return null before the data
     * are completely read - i.e. infinite flow case - then you should set true to prevent the
     * execution to complete when null is encountered.
     *
     * Default cases matches a batch case whereas when set to true it matches a stream case.
     *
     * @return true if the underlying input can be used as a stream and not in batch context.
     */
    boolean infinite() default false;
}
