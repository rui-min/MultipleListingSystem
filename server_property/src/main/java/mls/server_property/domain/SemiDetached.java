package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
//@Table(name = "semidetached")
public class SemiDetached extends Freehold {
    protected SemiDetached() {}

    public SemiDetached( @JsonProperty("id") Long id,
                         @JsonProperty("address") String address,
                         @JsonProperty("price") Integer price,
                         @JsonProperty("no_parking_space") Integer nOfParkingSpace,
                         @JsonProperty("storage_type") String storageType,
                         @JsonProperty("no_storage") Integer nOfStorages,
                         @JsonProperty("build_date") Date builtDate,
                         @JsonProperty("family_type") String type,
                         @JsonProperty("floors") Integer numberOfFloors,
                         @JsonProperty("is_multi_gen") boolean isMultigeneration) {
        super(id, address, price, nOfParkingSpace, storageType, nOfStorages, builtDate, type, numberOfFloors, isMultigeneration);
    }
}
