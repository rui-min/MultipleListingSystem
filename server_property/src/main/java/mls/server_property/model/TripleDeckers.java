package mls.server_property.model;
import java.time.LocalDate;


/**
 * Concrete class representing Building: Triple Deckers (level 4)
 */
public class TripleDeckers extends Condominium{

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public TripleDeckers(Long uuid, String address, int price) {
        super(uuid, address, price);
    }


}
