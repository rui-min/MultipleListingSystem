package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
@Table(name = "MobileHome")
public class MobileHome extends Residential {
    @Column(name = "MobileHome")
    private String ownership;
    public MobileHome() {super();}
    /**
     * Simple constructor for MobileHome.
     * @param address address of property as String.
     * @param price price of property in int.
     */
    @JsonCreator
    public MobileHome(@JsonProperty("id") Long id,@JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(id, address, price);
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
