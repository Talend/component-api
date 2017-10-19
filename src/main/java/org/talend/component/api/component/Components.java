package org.talend.component.api.component;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Enable to configure the component by module (package).
 */
@Target(PACKAGE)
@Retention(RUNTIME)
public @interface Components {
    /**
     * @return the family value for all classes needing a component in this package or subpackages.
     */
    String family();

    /**
     * @return the categories to associate to this component. Default to "Misc".
     */
    String[] categories() default {"Misc"};
}
