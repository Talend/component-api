package org.talend.component.api.component;

import java.util.Map;

/**
 * Migrate a tcomp data instance from one version to another one.
 *
 * This uses a flat format to make any conversion very easy and an "untyped" structure to avoid
 * <ul>
 * <li>to require the type to be passed through the layers</li>
 * <li>to require to instantiate unknown objects</li>
 * </ul>
 *
 * This is linked to a component through {@link Version} to ensure cross inputs can be handled.
 */
public interface MigrationHandler {

    /**
     * @param incomingVersion the version of associatedData values.
     * @param incomingData the data sent from the caller. Keys are using the path of the property as in component metadata.
     * @return the set of properties for the current version.
     */
    Map<String, String> migrate(int incomingVersion, Map<String, String> incomingData);
}
