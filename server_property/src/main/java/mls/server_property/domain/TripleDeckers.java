package mls.server_property.domain;
<<<<<<< Updated upstream
=======
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;
>>>>>>> Stashed changes


/**
 * Concrete class representing Building: Triple Deckers (level 4)
 */
<<<<<<< Updated upstream
=======
@Entity
@NoArgsConstructor
>>>>>>> Stashed changes
public class TripleDeckers extends Condominium{

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public TripleDeckers(Long uuid, String address, int price) {
        super(uuid, address, price);
    }

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
}
