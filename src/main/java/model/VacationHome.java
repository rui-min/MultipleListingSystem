package model; /**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import java.util.UUID;

public class VacationHome extends Freehold {

    public VacationHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


    /**
     * return a String using the superClass's toString()
     * @return String
     */
    @Override
    public String toString() {
        return "VacationHome{" + "\n" +
                super.toString() +
                "}";
    }
}
