package model; /**
 * Concrete class representing Detached Home (level 4)
 */
import java.util.UUID;

public class DetachedHome extends Freehold {
    public DetachedHome(UUID uuid, String address, int price) {
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
