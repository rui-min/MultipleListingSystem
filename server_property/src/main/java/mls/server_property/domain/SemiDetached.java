package mls.server_property.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("Property_Residential_Freehold_SemiDetached")
public class SemiDetached extends Freehold {
//    public SemiDetached(Long uuid, String address, int price) {
//        super(address, price);
//    }

}
