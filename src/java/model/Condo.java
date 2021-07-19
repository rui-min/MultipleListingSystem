package model;
import java.util.UUID;

/**
 * Concrete class representing Building: Condo (level 4)
 */
public class Condo extends Condominium {
    /**
     * final constant attribute representing current class's unique title in the format
     * "superclass's TITLE - current class's TITLE"
     */
    private final String TITLE = super.getTITLE() + " - " + this.getClass().getSimpleName();

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Condo(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * Get TITLE of current class. Override superclass's same method.
     * @return TITLE of current class
     */
    @Override
    public String getTITLE() {
        return TITLE;
    }

    /**
     * Override superclass's toString() method. Create a string representation of current class
     * @return the string representation of current class
     */
    @Override
    public String toString() {
        return "StackedTownHouse{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", howManyParks=" + getHowManyParks() +
                ", unitNumber=" + getUnitNumber() +
                ", howManyLockerStorage=" + getHowManyLockerStorage() +
                ", TITLE='" + TITLE + '\'' +
                '}';
    }


}
