package mls.server_property.model;

import java.util.UUID;

/**
 * Concrete class representing Cooperative home (level 3)
 */
public class CooperativeHome extends Residential {

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
     * Getter for ownership type
     * @return ownership type
     */
    @Override
    public String getOwnership() {
        return "Cooperative Home";
    }


}
