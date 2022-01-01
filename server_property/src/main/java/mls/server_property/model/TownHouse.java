package mls.server_property.model;
/**
 * Concrete class representing Town house (level 4)
 */
import java.time.LocalDate;

public class TownHouse extends Freehold {
    public TownHouse(Long uuid, String address, int price) {
        super(uuid, address, price);
    }

}
