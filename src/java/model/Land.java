package model;

import java.util.UUID;

/**
 * Concrete class representing listed vacant land (level 2)
 */
public class Land extends Property {

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid    the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price   an initial price set to the listing property
     */
    public Land(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


}