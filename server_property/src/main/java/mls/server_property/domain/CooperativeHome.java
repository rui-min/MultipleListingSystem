package mls.server_property.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Concrete class representing Cooperative home (level 3)
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("Property_Residential_CooperativeHome")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class CooperativeHome extends Residential {

    /**
     * Getter for ownership type
     * @return ownership type
     */
    @Override
    public String getOwnership() {
        return "Cooperative Home";
    }


}