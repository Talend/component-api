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

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class BufferizedProducerSupportTest {

    @Test
    public void iterate() {
        final Iterator<List<String>> strings = asList(asList("a", "b"), asList("c"), asList("d", "e", "f")).iterator();
        final BufferizedProducerSupport<String> support = new BufferizedProducerSupport<>(
                () -> strings.hasNext() ? strings.next().iterator() : null);
        assertEquals("a", support.next());
        assertEquals("b", support.next());
        assertEquals("c", support.next());
        assertEquals("d", support.next());
        assertEquals("e", support.next());
        assertEquals("f", support.next());
        assertNull(support.next());
    }
}
