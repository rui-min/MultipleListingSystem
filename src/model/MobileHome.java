package model;

/**
 * Concrete class representing Mobile home (level 3)
 */
import java.util.UUID;

public class MobileHome extends Residential {

    private int parkingSlot = 0;

    public MobileHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public int getHowManyParks() {
        return parkingSlot;
    }

    public void setHowManyParks(int howManyParks) {
        this.parkingSlot = howManyParks;
    }

    @Override
    public String toString(){
        return String.format("%s{uuid=%s, address=%s, price=%d, parking=%d}",
                this.getClass().getSimpleName(), this.getUuid(), this.getAddress(), this.getPrice(), this.parkingSlot);
    }
}
