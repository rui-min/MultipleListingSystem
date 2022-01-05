package mls.server_property.domain;
<<<<<<< Updated upstream
//todo
// constuctors, uuid, JPA annotations
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@MappedSuperclass
public abstract class Condominium extends Residential {
    @Column(unitNumber = "unitNumber")
=======

import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

//todo
// constuctors, uuid, JPA annotations
@NoArgsConstructor
@MappedSuperclass
public abstract class Condominium extends Residential {

>>>>>>> Stashed changes
    private int unitNumber;

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
<<<<<<< Updated upstream
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    protected Freehold(){super();}
    @JsonCreator
    public Condominium(@JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(address, price);
        this.unitNumber = 0;
    }

=======
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Condominium(Long uuid, String address, int price) {
        super(address, price);
    }

    public Condominium(String address, int price) {
        super(address, price);
    }


>>>>>>> Stashed changes
    /**
     * Abstract method to be completed in subclass to return ownership type as a string
     * @return the type of ownership as a string
     */
    @Override
    public String getOwnership() {
        return "Condominium";
    }

    /**
     * Get unit number of the condominium type property
     * @return unit number of condominium type property
     */
    public int getUnitNumber() {
        return unitNumber;
    }

    /**
     * Set unit number of the condominium type property
     * @param unitNumber unit number of condominium type property
     */
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * Override equals() method. Evaluate objects' equality using attribute values.
     * For simplification, it is assumed that same address and unit number represents same property.
     * @param o other Object for comparison
     * @return a boolean value "true" if specified attribute values are same, otherwise "false"
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Condominium other = (Condominium) o;
        return this.getAddress().equals(other.getAddress())
                && this.getUnitNumber() == other.getUnitNumber();
    }

    /**
     * Override superclass's toString() method. Create a string representation of current class
     * @return the string representation of current class
     */
    @Override
    public String toString() {
        return  super.toString() +
                ", unitNumber=" + unitNumber;
    }

}
