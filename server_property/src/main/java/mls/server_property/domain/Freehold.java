package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.sql.Date;
@Entity
//@DiscriminatorColumn(name="f_type")
@Table(name="freehold")
//@DiscriminatorValue("f")
public abstract class Freehold extends Residential {
    @Column(name = "family_type")
    private String type;

    @Column(name = "floors")
    private int numberOfFloors;

    @Column(name = " is_multi_gen")
    private boolean isMultigeneration;

    protected Freehold(){super();}

    @JsonCreator
    public Freehold(@JsonProperty("id") Long id,
                    @JsonProperty("address") String address,
                    @JsonProperty("price") int price,
                    @JsonProperty("no_parking_space") int nOfParkingSpace,
                    @JsonProperty("storage_type") String storageType,
                    @JsonProperty("no_storage") int nOfStorages,
                    @JsonProperty("build_date") Date builtDate,
                    @JsonProperty("family_type") String type,
                    @JsonProperty("floors") int numberOfFloors,
                    @JsonProperty("is_multi_gen") boolean isMultigeneration) {
        super(id, address, price, nOfParkingSpace, storageType, nOfStorages, builtDate);
        this.type = type;
        this.numberOfFloors = numberOfFloors;
        this.isMultigeneration = isMultigeneration;
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
