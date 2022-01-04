package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@MappedSuperclass
public abstract class Freehold extends Residential {
    @Column(name = "family_type")
    private String type;

    @Column(name = "floors")
    private int numberOfFloors;

    @Column(name = " is_multi_gen")
    private boolean isMultigeneration;

    protected Freehold(){super();}

    @JsonCreator
    public Freehold( @JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(address, price);
        this.type = null;
        this.numberOfFloors = 0;
        this.isMultigeneration = false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public String getOwnership() {
        return "Freehold";
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public boolean isMultigeneration() {
        return this.isMultigeneration;
    }

    public void setMultigeneration(boolean isMultigeneration){
        this.isMultigeneration = isMultigeneration;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                ", type=" + type +
                ", numberOfFloors=" + this.numberOfFloors +
                ", isMultigeneration=" + this.isMultigeneration
                ;
    }
}
