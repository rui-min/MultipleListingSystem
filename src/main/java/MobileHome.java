/**
 * Concrete class representing Mobile home (level 3)
 */
import java.util.UUID;

public class MobileHome extends Residential {

    public MobileHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    @Override
    public int getHowManyParks() {
        // TODO
        return 0;
    }

    @Override
    public void setHowManyParks(int howManyParks) {
        // TODO
    }

    //.toString() TODO
}
