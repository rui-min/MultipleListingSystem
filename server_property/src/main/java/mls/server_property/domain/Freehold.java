package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.sql.Date;
@Entity
//@DiscriminatorColumn(name="f_type")
//@Table(name="freehold")
//@DiscriminatorValue("f")
public abstract class Freehold extends Residential {
    @Column(name = "family_type")
    private String type;

    @Column(name = "floors")
    private Integer numberOfFloors;

    @Column(name = " is_multi_gen")
    private Boolean isMultigeneration;

    protected Freehold(){super();}

    @JsonCreator
    public Freehold(@JsonProperty("id") Long id,
                    @JsonProperty("address") String address,
                    @JsonProperty("price") Integer price,
                    @JsonProperty("no_parking_space") Integer nOfParkingSpace,
                    @JsonProperty("storage_type") String storageType,
                    @JsonProperty("no_storage") Integer nOfStorages,
                    @JsonProperty("build_date") Date builtDate,
                    @JsonProperty("family_type") String type,
                    @JsonProperty("floors") Integer numberOfFloors,
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

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public String getOwnership() {
        return "Freehold";
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Boolean isMultigeneration() {
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
