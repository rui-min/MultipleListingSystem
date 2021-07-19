package model;

import java.util.UUID;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
public class SemiDetached extends Freehold {
    public SemiDetached(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public int getHowManyGenerations() {
        return 0;
    }

    public void setHowManyGenerations(int howManyGenerations) {

    }

    public int getHowManyParks() {
        return 0;
    }

    public void setHowManyParks(int howManyParks) {

    }
}
