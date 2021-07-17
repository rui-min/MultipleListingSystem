package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: model.Residential type (level 2)
 */
//import java.time.Period;
public abstract class Residential extends Property implements ParkingSpaces {
    /**
     * There is only one copy of the static attribute shared among the declaring class
     * and all subclasses. REFER_PRICE is a package-wide indicator, and residential properties
     * with prices higher than or equal to it are called "High Value model.Residential model.Property"
     */
    public static final int REFER_PRICE = 10000000;

    private Period availability;    // TODO!
    private LocalDate buildDate;    // TODO!
    private int howManyParks;
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
     * Check whether this model.Residential property is a High Value model.Property
     * @return true if it is larger than or equal to the indicator, otherwise false
     */
    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    /**
     * override the abstract method in Generation interface
     * get howManyGenerations in this house
     * @return the number of Parking Space.
     */
    @Override
    public int getHowManyParks() {
        return this.howManyParks;
    }

    /**
     * override the abstract method in Generation interface.
     * Set howManyGenerations in this house
     * @param howManyParks the number of generations living here.
     */
    @Override
    public void setHowManyParks(int howManyParks){
        this.howManyParks = howManyParks;
    };
    /**
     * Override superclass's toString() method. Create a string representation of this class.
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return
                super.toString() + " ,"  +
                ", highValue=" + this.isHighValue() +
                ", REFER_PRICE=" + Residential.REFER_PRICE +
                ", howManyParks=" + howManyParks
                ;
    }
}
