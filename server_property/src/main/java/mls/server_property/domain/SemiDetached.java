package mls.server_property.domain;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
public class SemiDetached extends Freehold {
    public SemiDetached(Long uuid, String address, int price) {
        super(address, price);
    }

}
