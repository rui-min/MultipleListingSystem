package model;

/**
 * Interface helps achieve Abstraction.
 * The interface "model.Generations" forces implemented class(es) to include one getter
 * method and one setter method related to generations living in the property.
 */
public interface Generations {
    public int getHowManyGenerations();
    public void setHowManyGenerations(int howManyGenerations);
}
