import java.util.UUID;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
public class SemiDetached extends Freehold {
    public SemiDetached(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    @Override
    public int getHowManyGenerations() {
        return 0;
    }

    @Override
    public void setHowManyGenerations(int howManyGenerations) {

    }

    @Override
    public int getHowManyParks() {
        return 0;
    }

    @Override
    public void setHowManyParks(int howManyParks) {

    }
}
