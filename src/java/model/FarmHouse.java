package model; /**
 * Concrete class representing Farm House (level 4)
 */
import java.util.UUID;

public class FarmHouse extends Freehold {
    public FarmHouse(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * An abstract method, which cannot be finished here and must be implemented
     * by non-abstract subclass.
     *
     * @return the number of parking spaces.
     */
    @Override
    public int getHowManyParks() {
        return 0;
    }

    /**
     * An abstract method, which cannot be finished here and must be implemented
     * by non-abstract subclass.
     *
     * @param howManyParks the number of parking spaces.
     */
    @Override
    public void setHowManyParks(int howManyParks) {

    }

}
