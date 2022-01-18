package mls.server_property.domain;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
//@Table(name = "cooperativehome")
public class CooperativeHome extends Residential {

    protected CooperativeHome() {}

    @JsonCreator
    public CooperativeHome( @JsonProperty("id") Long id,
                            @JsonProperty("address") String address,
                            @JsonProperty("price") Integer price,
                            @JsonProperty("no_parking_space") Integer nOfParkingSpace,
                            @JsonProperty("storage_type") String storageType,
                            @JsonProperty("no_storage") Integer nOfStorages,
                            @JsonProperty("build_date") Date builtDate){
        super(id,address,price,nOfParkingSpace,storageType,nOfStorages,builtDate);
    }

    /**
     * Getter for ownership type
     * @return ownership type
     */
    @Override
    public String getOwnership() {
        return "Cooperative Home";
    }


}