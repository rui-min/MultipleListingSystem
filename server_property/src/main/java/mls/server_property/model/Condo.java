package mls.server_property.model;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Concrete class representing Building: Condo (level 4)
 */
public class Condo extends Condominium {
    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Condo(Long uuid, String address, int price) {
        super(uuid, address, price);
    }
}
