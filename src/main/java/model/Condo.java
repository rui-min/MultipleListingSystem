/**
 * Concrete class representing Condo (level 4)
 */
import java.util.UUID;

public class Condo extends Condominium {
    public Condo(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


    @Override
    public String getBuildingType() {
        return "Condo";
    }

}
