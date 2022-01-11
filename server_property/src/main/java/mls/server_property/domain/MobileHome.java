package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
//@Table(name = "MobileHome")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("Property_Residential_MobileHome")
public class MobileHome extends Residential {
    @Column
    private String ownership;


    /**
     * Simple constructor for MobileHome.
     * @param address address of property as String.
     * @param price price of property in int.
     */
    @JsonCreator
    public MobileHome(@JsonProperty("id") Long id, @JsonProperty("address") String address,
                      @JsonProperty("price") int price, @JsonProperty("no_parking_space") int nOfParkingSpace,
                      @JsonProperty("storage_type") String storageType, @JsonProperty("no_storage") int nOfStorages,
                      @JsonProperty("build_date") Date builtDate, @JsonProperty("ownership") String ownership) {
        super(id, address, price, nOfParkingSpace, storageType, nOfStorages, builtDate);
        this.ownership = ownership;
    }


    /**
     * Getter for ownership type
     * @return ownership type
     */
    @Override
    public String getOwnership() {
        return this.ownership;
    }

//    @Override
//    public String toString() {
//        return "MobileHome{" +
//                super.toString()+ '\'' +
//                "} " + "ownership='" + ownership;
//    }
}
