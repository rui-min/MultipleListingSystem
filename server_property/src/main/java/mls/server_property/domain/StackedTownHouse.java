package mls.server_property.domain;
<<<<<<< Updated upstream
=======
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;
>>>>>>> Stashed changes

/**
 * Concrete class representing Building: Stacked Townhouse (level 4)
 */
<<<<<<< Updated upstream
=======
@Entity
@NoArgsConstructor
>>>>>>> Stashed changes
public class StackedTownHouse extends Condominium {

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public StackedTownHouse(Long uuid, String address, int price) {
        super(uuid, address, price);
    }

}
