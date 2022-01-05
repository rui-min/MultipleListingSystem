package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Concrete class representing Cooperative home (level 3)
 */
@Entity
@Table(name="cooperativehome")
public class CooperativeHome extends Residential {

    protected CooperativeHome(){ super(); }

    @JsonCreator
    public CooperativeHome(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(id, address, price);
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
