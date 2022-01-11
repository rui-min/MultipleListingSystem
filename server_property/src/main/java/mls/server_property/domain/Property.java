package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="p_type")
@Table(name="property")
//@DiscriminatorValue("property")
public abstract class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="address")
    private String address;

    @Column(name="price")
    private int price;

    @Column(name="p_type", insertable = false, updatable = false)
    private String ptype;

    @JsonCreator
    public Property(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
        this.id = id;
        this.address = address;
        this.price = price;
    }

    protected Property() {}

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBuildingType() {
        return this.getClass().getSimpleName();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property other = (Property) o;
        return this.address.equals(other.address);
    }

    /**
     * Override Object class's toString() method. Create a string representation of this Property
     *
     * @return the string representation of this Property
     */
    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", buildingType='" + getBuildingType() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}