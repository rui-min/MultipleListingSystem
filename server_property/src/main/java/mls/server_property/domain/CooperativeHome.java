package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "cooperativehome")
public class CooperativeHome extends Residential {

    @JsonCreator
    public CooperativeHome( @JsonProperty("id") Long id,
                            @JsonProperty("address") String address,
                            @JsonProperty("price") int price,
                            @JsonProperty("no_parking_space") int nOfParkingSpace,
                            @JsonProperty("storage_type") String storageType,
                            @JsonProperty("no_storage") int nOfStorages,
                            @JsonProperty("build_date") Date builtDate){
        super(id,address,price,nOfParkingSpace,storageType,nOfStorages,builtDate);
    }

    protected CooperativeHome() { }

    /**
     * Getter for ownership type
     * @return ownership type
     */
    @Override
    public String getOwnership() {
        return "Cooperative Home";
    }


}