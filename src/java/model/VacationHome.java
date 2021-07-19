package model;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import java.util.UUID;

public class VacationHome extends Freehold {

    public VacationHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

}
