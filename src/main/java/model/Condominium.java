package model;

import java.util.UUID;
/**
 * Abstract class representing Condominium Type (level 3)
 */
public abstract class Condominium extends Residential {
    private String unitNumber;

    public Condominium(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    @Override
    public String getOwnership() {
        return "Condominium";
    }

    public String getUnitNumber() {
        return this.unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public String toString() {
        return  this.getBuildingType() +" " + this.getOwnership()+ "{" +
                "uuid=" + this.getUuid() +
                ", address='" + this.getAddress() + '\'' +
                ", price=" + this.getPrice() +
                ", numberOfParkingSpace=" + this.howManyParkingSpace() +
                ", storage=" + this.getStorageType() + " " + this.howManyStorage() +
                ", highValue=" + this.isHighValue() +
                '}';
    }

}
