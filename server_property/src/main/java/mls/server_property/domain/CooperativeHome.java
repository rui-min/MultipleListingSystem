package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Concrete class representing Cooperative home (level 3)
 */
@Entity
@Table(name="Residential")
public class Residential extends Residential {

    protected Residential(){ super(); }

    @JsonCreator
    public Residential(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
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
