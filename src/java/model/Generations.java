

/**
 * Interface helps achieve Abstraction.
 * The interface "Generations" forces implemented class(es) to include one getter
 * method and one setter method related to generations living in the property.
 */
public interface Generations {
    public boolean isMultigeneration();
    public void setMultigeneration(boolean isMultigeneration);
}
