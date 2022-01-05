package mls.server_property.domain;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;


@Entity
@Table(name="vacationhome")
public class VacationHome extends Freehold {

    protected VacationHome(){
        super();
    }
    public VacationHome( @JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(address, price);
    }

}
