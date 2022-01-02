package mls.server_property.model;
/**
 * Concrete class representing Detached Home (level 4)
 */
import java.time.LocalDate;
import java.util.UUID;


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