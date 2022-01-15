package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Concrete class representing Building: Stacked Townhouse (level 4)
 */
@Getter
@Setter
@Builder
@Entity
//@Table(name = "stackedtownhouse")
public class StackedTownHouse extends Condominium {

    @JsonCreator
    public StackedTownHouse(@JsonProperty("id") Long id, @JsonProperty("address") String address,
                 @JsonProperty("price") int price, @JsonProperty("no_parking_space") int nOfParkingSpace,
                 @JsonProperty("storage_type") String storageType, @JsonProperty("no_storage") int nOfStorages,
                 @JsonProperty("build_date") Date builtDate, @JsonProperty("unit_No") int unitNumber) {
        super(id, address, price, nOfParkingSpace, storageType, nOfStorages, builtDate,unitNumber);
    }

    protected StackedTownHouse() {}

}
