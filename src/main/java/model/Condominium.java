package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: model.Condominium type (level 3)
 */
public abstract class Condominium extends Residential implements LockerStorage {
    private final String TITLE = "model.Condominium";
    private int unitNumber = -1;

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

    public abstract int getHowManyLockerStorage();
    public abstract void setHowManyLockerStorage(int howManyLockerStorage);


}
