package model; /**
 * Concrete class representing Stacked Townhouse (level 4)
 */
import java.util.UUID;

public class StackedTownHouse extends Condominium {
    public StackedTownHouse(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    @Override
    public int howManyLockerStorage() {
        return 0;
    }

    @Override
    public void setHowManyLockerStorage(int howManyLockerStorage) {

    }

    @Override
    public int getHowManyParks() {
        return 0;
    }

    @Override
    public void setHowManyParks(int howManyParks) {

    }

    //toString() TODO
}
