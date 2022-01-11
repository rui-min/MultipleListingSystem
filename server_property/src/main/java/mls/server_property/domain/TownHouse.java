package mls.server_property.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Concrete class representing Town house (level 4)
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("Property_Residential_Freehold_TownHouse")
public class TownHouse extends Freehold {
//    public TownHouse(Long uuid, String address, int price) {
//        super(address, price);
//    }

}
