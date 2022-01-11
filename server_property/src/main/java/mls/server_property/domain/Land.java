package mls.server_property.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Concrete class representing listed vacant land (level 2)
 */
@Entity(name = "land")
//@Table(name = "land")
@DiscriminatorValue("Property_Land")
@NoArgsConstructor
@SuperBuilder
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
}