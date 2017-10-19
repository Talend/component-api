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
package org.talend.component.api.processor.data;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Set;

public interface ObjectMap {

    Object get(String location);

    ObjectMap getMap(String location);

    Collection<ObjectMap> getCollection(String location);

    Set<String> keys();

    // todo: think about map?

    /**
     * Mark a {@link java.util.Map}&lt;String, Object&gt; field as containing virtual fields
     * accessible using objectMap.get(x) directly.
     */
    @Target(FIELD)
    @Retention(RUNTIME)
    @interface Any {
    }
}
