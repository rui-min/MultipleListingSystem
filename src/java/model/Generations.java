package model;

/**
 * Interface helps achieve Abstraction.
 * The interface "java.model.Generations" forces implemented class(es) to include one getter
 * method and one setter method related to generations living in the property.
 */
public interface Generations {
    default int getHowManyGenerations(){
        return 1;
    };
    void setHowManyGenerations(int howManyGenerations);
}
