package model;

/**
 * Interface helps achieve Abstraction.
 * The interface "model.ParkingSpaces" forces implemented class(es) to include one getter
 * method and one setter method related to number of parking spaces in the property.
 */
public interface ParkingSpaces {
    int getHowManyParks();
    void setHowManyParks(int howManyParks);
}
