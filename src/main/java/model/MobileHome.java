package model; /**
 * Concrete class representing Mobile home (level 3)
 */
import java.util.UUID;

public class MobileHome extends Residential {
    private String ownership;

    public MobileHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


    @Override
    public String getOwnership() {
        return null;
    }

    //.toString() TODO
}
