package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: java.model.Residential type (level 2)
 */
//import java.time.Period;
public abstract class Residential extends Property implements ParkingSpaces {
    /**
     * There is only one copy of the static attribute shared among the declaring class
     * and all subclasses. REFER_PRICE is a package-wide indicator, and residential properties
     * with prices higher than or equal to it are called "High Value java.model.Residential java.model.Property"
     */
    public static final int REFER_PRICE = 750000;

    private int howManyParks = 0;

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Residential(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * Check whether this java.model.Residential property is a High Value java.model.Property
     * @return true if it is larger than or equal to the indicator, otherwise false
     */
    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    /**
     * An abstract method, which cannot be finished here and must be implemented
     * by non-abstract subclass.
     * @return the number of parking spaces.
     */
    public int getHowManyParks() {
        return this.howManyParks;
    }

    /**
     * An abstract method, which cannot be finished here and must be implemented
     * by non-abstract subclass.
     * @param howManyParks the number of parking spaces.
     */
    public void setHowManyParks(int howManyParks) {
        this.howManyParks = howManyParks;
    }

    /**
     * Override superclass's toString() method. Create a string representation of this class.
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                '}';
    }
}
