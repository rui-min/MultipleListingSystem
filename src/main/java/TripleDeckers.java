/**
 * Concrete class representing Mobile home (level 4)
 */
import java.util.UUID;

public class TripleDeckers extends Condominium{
    public TripleDeckers(UUID uuid, String address, int price) {
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
}
