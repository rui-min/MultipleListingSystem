package mls.server_property.domain;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("Property_Residential_Freehold_VacationHome")
//@Table(name="vacationhome")
public class VacationHome extends Freehold {

//    public VacationHome( @JsonProperty("address") String address, @JsonProperty("price") int price) {
//        super(address, price);
//    }

}
