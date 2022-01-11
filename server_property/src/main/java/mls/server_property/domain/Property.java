package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Objects;

//@MappedSuperclass
@Entity(name = "property")
@Table(name = "realproperty")
@Inheritance
@DiscriminatorColumn(name = "property_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Property")
@Data
@SuperBuilder
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="address", nullable = false, unique = true)
    private String address;

    @Column(name="price")
    private int price;

    @JsonCreator
    public Property(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
        this.id = id;
        this.address = address;
        this.price = price;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}