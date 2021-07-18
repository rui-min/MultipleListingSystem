package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: java.model.Condominium type (level 3)
 */
public abstract class Condominium extends Residential implements LockerStorage {
    private final String TITLE = "Condominium";
    private int unitNumber = 0;
    private int howManyLockerStorage = 0;

    public Condominium(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public String getTITLE() {
        return TITLE;
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

    @Override
    public String toString() {
        return "Condominium{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", howManyParks=" + getHowManyParks() +
                ", unitNumber=" + unitNumber +
                ", howManyLockerStorage=" + howManyLockerStorage +
                '}';
    }

}
