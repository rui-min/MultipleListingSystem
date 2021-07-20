package model;

/**
 * Interface helps achieve Abstraction.
 * The interface "ParkingSpaces" forces implemented class(es) to include one getter
 * method and one setter method related to number of parking spaces in the property.
 */
public interface ParkingSpaces {
    public int howManyParkingSpace();

    public void setParkingSpace( int howMany);
}
