package mls.server_property.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Concrete class representing Detached Home (level 4)
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("Property_Residential_Freehold_DetachedHome")
public class DetachedHome extends Freehold {

    /**
     * Construct a new DatachedHome given its Long, address and price.
     * @param uuid the unique id of the new DatachedHome
     * @param address the address of the new DatachedHome
     * @param price the price of the new DatachedHome
     */
//    public DetachedHome(Long uuid, String address, int price) {
//        super( address, price);
//    }

}