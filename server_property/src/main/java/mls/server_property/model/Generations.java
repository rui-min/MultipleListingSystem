
package mls.server_property.model;
/**
 * Interface helps achieve Abstraction.
 * The interface "Generations" forces implemented class(es) to include one getter
 * method and one setter method related to generations living in the property.
 */
public interface Generations {
    /**
     * Get whether the object can be multi-generational.
     * @return true, if the object can be multi-generational.
     */
    public boolean isMultigeneration();

    /**
     * Set whether theo bject can be multi-generational.
     * @param isMultigeneration
     */
    public void setMultigeneration(boolean isMultigeneration);
}
