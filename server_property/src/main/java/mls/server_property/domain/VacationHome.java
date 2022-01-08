package mls.server_property.domain;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="vacationhome")
public class VacationHome extends Freehold {

    protected VacationHome(){
        super();
    }
    public VacationHome( @JsonProperty("id") Long id,
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

}
