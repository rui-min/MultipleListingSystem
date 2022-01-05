package mls.server_property.domain;
/**
 * Concrete class representing Detached Home (level 4)
 */


public class DetachedHome extends Freehold {

    /**
     * Construct a new DatachedHome given its Long, address and price.
     * @param uuid the unique id of the new DatachedHome
     * @param address the address of the new DatachedHome
     * @param price the price of the new DatachedHome
     */
    public DetachedHome(Long uuid, String address, int price) {
        super( address, price);
    }



}