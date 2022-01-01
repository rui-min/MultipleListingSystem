package mls.server_property.model;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name="VacationHome")
public class VacationHome extends Freehold {

    protected VacationHome(){
        super();
    }
    public VacationHome(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(id, address, price);
    }

    public static void main(String[] args) {
        VacationHome vh = new VacationHome(Long.valueOf(1), "haha", 1000);
    }
}
