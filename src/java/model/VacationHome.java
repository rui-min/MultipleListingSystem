package model; /**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import java.util.UUID;

public class VacationHome extends Freehold {

    public VacationHome(UUID uuid, String address, int price) {
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
