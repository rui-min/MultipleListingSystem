package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: Condominium type (level 3)
 */
public abstract class Condominium extends Residential implements LockerStorage {
    /**
     * Unit number of the condominium type property.
     */
    private int unitNumber;
    /**
     * Number of locker storages, 0 by default
     */
    private int howManyLockerStorage = 0;

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Condominium(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * Ownership Type of the property, disallow subclasses' overridden
     * @return Ownership type of the property
     */
    @Override
    public final String getOwnership() {
        return "Condominium";
    }

    /**
     * Get unit number of the condominium type property.
     * @return unit number condominium type property
     */
    public int getUnitNumber() {
        return unitNumber;
    }

    /**
     * Set unit number of the condominium type property.
     * @param unitNumber unit number condominium type property
     */
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getHowManyLockerStorage() {
        return this.howManyLockerStorage;
    }


    public void setHowManyLockerStorage(int howManyLockerStorage) {
        this.howManyLockerStorage = howManyLockerStorage;
    }
    /**
     * Override superclass's toString() method. Create a string representation of current class
     * @return the string representation of current class
     */
    @Override
    public String toString() {
        return  getBuildingType() + "{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", unitNumber=" + unitNumber +
                ", buildingType='" + getBuildingType() + '\'' +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", howManyParkingSpace=" + howManyParkingSpace() +
                ", howManyStorage=" + howManyStorage() +
                '}';
    }

}
