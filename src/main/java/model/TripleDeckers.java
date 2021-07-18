package model;
import java.util.UUID;

/**
 * Concrete class representing Triple Deckers (level 4)
 */
public class TripleDeckers extends Condominium{

    public TripleDeckers(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    private int howManyLockerStorageInBuilding = 0;
    private int howManyParks = 0;

    @Override
    public int getHowManyLockerStorage() {
        return howManyLockerStorageInBuilding;
    }

    @Override
    public void setHowManyLockerStorage(int howManyLockerStorage) {
        this.howManyLockerStorageInBuilding = howManyLockerStorage;
    }

    @Override
    public int getHowManyParks() {
        return howManyParks;
    }

    @Override
    public void setHowManyParks(int howManyParks) {
        this.howManyParks = howManyParks;
    }
}
