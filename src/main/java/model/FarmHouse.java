package model; /**
 * Concrete class representing Farm House (level 4)
 */
import java.util.UUID;

public class FarmHouse extends Freehold {
    public FarmHouse(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * return a String using the superClass's toString()
     * @return String
     */
    @Override
    public String toString() {
        return "FarmHouse{" + "\n" +
                super.toString() +
                "}";
    }
}
