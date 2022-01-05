package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
<<<<<<< Updated upstream

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="address")
    private String address;

    @Column(name="price")
    private int price;

    @JsonCreator
    public Property(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
        this.id = id;
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private int price;

    @JsonCreator
    public Property(@JsonProperty("address") String address, @JsonProperty("price") int price) {
//        this.id = id;
>>>>>>> Stashed changes
        this.address = address;
        this.price = price;
    }

<<<<<<< Updated upstream
    protected Property() {}

    /**
     * Get the id of the property
     * @return id of the property
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the address of the property
     * @return address of the property
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the property
     * @param address address of the property
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the price of the property
     * @return price of the property
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the property
     * @param price price of the property
     */
    public void setPrice(int price) {
        this.price = price;
    }
=======
>>>>>>> Stashed changes

    /**
     * Called by subclass instance.
     * @return return the concrete class name of a subclass instance.
     */
    public String getBuildingType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Override Object class's equals() method. Evaluate objects' equality using attribute values
     * For simplification, it is assumed that same address represents same property.
     * @param o other Object for comparison
     * @return a boolean value "true" if specified attribute values are same, otherwise "false"
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property other = (Property) o;
        return this.address.equals(other.address);
    }

    /**
     * Override Object class's toString() method. Create a string representation of this Property
     * @return the string representation of this Property
     */
    @Override
    public String toString() {
        return String.format("%s{id=%s, address=%s, price=%d}",
                this.getBuildingType(), this.getId(), this.getAddress(), this.getPrice());
    }

<<<<<<< Updated upstream
    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
=======
>>>>>>> Stashed changes
}