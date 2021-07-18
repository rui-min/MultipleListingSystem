package model; /**
 * Concrete class representing Town house (level 4)
 */
import java.util.UUID;

public class TownHouse extends Freehold {
    /**
     *
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public TownHouse(UUID uuid, String address, int price) {
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

    /**
     * return a String using the superClass's toString()
     * @return String
     */
    @Override
    public String toString() {
        return "TownHouse{" + "\n" +
                super.toString() +
                "}";
    }
}
