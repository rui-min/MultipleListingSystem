package mls.server_property.domain;

/**
 * Concrete class representing Mobile home (level 3)
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@MappedSuperclass
public class MobileHome extends Residential {

    private String ownership;

    /**
     * Simple constructor for MobileHome.
     * @param address address of property as String.
     * @param price price of property in int.
     */
    @JsonCreator
    public MobileHome(@JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(address, price);
    }

    /**
     * Setter for ownership type
     * @param ownership ownership type
     */
    public void setOwnership(String ownership){
        this.ownership = ownership;
    }

    /**
     * Getter for ownership type
     * @return ownership type
     */
    @Override
    public String getOwnership() {
        return this.ownership;
    }


}
