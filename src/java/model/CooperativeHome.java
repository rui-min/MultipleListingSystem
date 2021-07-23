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

    @Override
    public String getOwnership() {
        return "Cooperative Home";
    }


}
