package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Concrete class representing MultiLex (level 4)
 */
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
//@Table(name = "multilex")
public class MultiLex extends Freehold {

//    private Integer nOfUnits;

    protected MultiLex() {}

    public MultiLex( @JsonProperty("id") Long id,
                         @JsonProperty("address") String address,
                         @JsonProperty("price") int price,
                         @JsonProperty("no_parking_space") int nOfParkingSpace,
                         @JsonProperty("storage_type") String storageType,
                         @JsonProperty("no_storage") int nOfStorages,
                         @JsonProperty("build_date") Date builtDate,
                         @JsonProperty("family_type") String type,
                         @JsonProperty("floors") int numberOfFloors,
                         @JsonProperty("is_multi_gen") boolean isMultigeneration) {
        super(id, address, price, nOfParkingSpace, storageType, nOfStorages, builtDate, type, numberOfFloors, isMultigeneration);
    }

//    public void setUnits(int n) {
//        this.nOfUnits = n;
//    }
//
//    @Override
//    public String getBuildingType() {
//
//        switch (this.nOfUnits) {
//            case 2:
//                return "Duplex";
//            case 3:
//                return "Triplex";
//            case 4:
//                return "Quadriplex";
//            default:
//                return "Multiplex (>4)";
//        }
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() +
//                ", howManyUnits=" + nOfUnits;
//    }

}
