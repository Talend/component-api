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
package org.talend.component.api.base;

import java.util.Iterator;
import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;

// helper class to implement {@link @org.talend.component.api.input.Producer}
// using a buffer
@RequiredArgsConstructor
public class BufferizedProducerSupport<T> {

    private final Supplier<Iterator<T>> supplier;

    private Iterator<T> current;

    public T next() {
        if (current == null || !current.hasNext()) {
            current = supplier.get();
        }
        return current != null && current.hasNext() ? current.next() : null;
    }
}
