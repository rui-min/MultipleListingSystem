package mls.server_property.model;

/**
 * Concrete class representing Cooperative home (level 3)
 */
public class CooperativeHome extends Residential {

    /**
     *Constructor for CooperativeHome obj requiring Long, address and price.
     * @param uuid Long of the instance.
     * @param address address of the property.
     * @param price price of the property.
     */
    public CooperativeHome(Long uuid, String address, int price) {
        super(address, price);
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
