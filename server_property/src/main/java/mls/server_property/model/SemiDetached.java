package mls.server_property.model;

import java.time.LocalDate;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
public class SemiDetached extends Freehold {
    public SemiDetached(Long uuid, String address, int price) {
        super(uuid, address, price);
    }

}
