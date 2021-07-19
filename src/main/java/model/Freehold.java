package model;

import java.util.UUID;
/**
 * Abstract class representing Condominium Type (level 3)
 */
public abstract class Freehold extends Residential implements Generations {

    private String type; // multi family or single family
    private int numberOfStoreys;
    private boolean isMultigeneration;

    public Freehold(UUID uuid, String address, int price) {
        super(uuid, address, price);
        this.numberOfStoreys = 0;
        this.type = null;
    }

    @Override
    public String getOwnership() {
        return "Freehold";
    }

    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }

    @Override
    public boolean isMultigeneration() {
        return this.isMultigeneration;
    }

    @Override
    public void setMultigeneration() {
        this.isMultigeneration = true;
    }

    @Override
    public String toString() {
        return  this.getBuildingType() +" " + this.getOwnership()+ "{" +
                "uuid=" + this.getUuid() +
                ", address='" + this.getAddress() + '\'' +
                ", price=" + this.getPrice() +
                ", type=" + this.getType() +
                ", storeys=" + this.getNumberOfStoreys() +
                ", numberOfParkingSpace=" + this.howManyParkingSpace() +
                ", storage=" + this.getStorageType() + " " + this.howManyStorage() +
                ", highValue=" + this.isHighValue() +
                ", multiGeneration=" + this.isMultigeneration() +
                '}';
    }

}
