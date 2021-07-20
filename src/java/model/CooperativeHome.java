package model;

/**
 * Concrete class representing Cooperative home (level 3)
 */
import java.util.UUID;

public class CooperativeHome extends Residential {

    private int parkingSlot = 0;

    /**
     *Constructor for CooperativeHome obj requiring UUID, address and price.
     * @param uuid UUID of the instance.
     * @param address address of the property.
     * @param price price of the property.
     */
    public CooperativeHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * Getter for parking slot #.
     * @return int value of parking slots.
     */
    public int getHowManyParks() {
        return parkingSlot;
    }

    /**
     * Setter for parking slot #.
     * @param howManyParks the number of parking spaces.
     */
    public void setHowManyParks(int howManyParks) {
        this.parkingSlot = howManyParks;
    }

}
