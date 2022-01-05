package mls.server_property.domain;
<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
>>>>>>> Stashed changes

/**
 * Concrete class representing Building: Condo (level 4)
 */
<<<<<<< Updated upstream

=======
@Entity
@NoArgsConstructor
@Table(name="condo")
>>>>>>> Stashed changes
public class Condo extends Condominium {
    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
<<<<<<< Updated upstream
    public Condo(Long uuid, String address, int price) {
        super(uuid, address, price);
    }
=======
    public Condo(@JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(address, price);
    }

>>>>>>> Stashed changes
}
