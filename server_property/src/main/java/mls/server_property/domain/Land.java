package mls.server_property.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Concrete class representing listed vacant land (level 2)
 */
@Entity
@Table(name = "land")
public class Land extends Property {

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param id    the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price   an initial price set to the listing property
     */
    @JsonCreator
    public Land(@JsonProperty("id")Long id,
                @JsonProperty("address")String address,
                @JsonProperty("price")int price) {
        super(id, address, price);
    }

    public Land() {}

    @Override
    public String toString() {
        return "Land{" +
                "id=" + getId() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", buildingType='" + getBuildingType() + '\'' +
                '}';
    }
}