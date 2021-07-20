package model;

import java.util.UUID;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
public class SemiDetached extends Freehold {
    public SemiDetached(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

}
