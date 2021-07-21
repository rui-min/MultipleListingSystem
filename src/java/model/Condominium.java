package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: Condominium type (level 3)
 */
public abstract class Condominium extends Residential implements LockerStorage {
    /**
     *
     */
    private int unitNumber;
    private int howManyLockerStorage;

    public Condominium(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    @Override
    public String getOwnership() {
        return "Condominium";
    }


    public int getUnitNumber() {
        return unitNumber;
    }

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
        return "Condominium{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", howManyParks=" + howManyParkingSpace() +
                ", unitNumber=" + unitNumber +
                ", howManyLockerStorage=" + howManyLockerStorage +
                '}';
    }

}
