package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Date;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Abstract class representing Residential Property (level 2)
 */
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public abstract class Residential extends Property {
    /**
     * The reference price used to decide whether a home is high value.
     */
    public static final int REFER_PRICE = 750000;

    @Column(name="no_parking_space")
    private   int         nOfParkingSpace;
    @Column(name="storage_type")
    private   String      storageType;
    @Column(name="no_storage")
    private   int         nOfStorages;
    @Column(name="build_date")
    private   Date   builtDate = Date.valueOf("1900-1-1");
    @Column(name="entry_date")
    private   Date   entryDate; // the day on which the object is entered in the system

    /**
      * Full args constructor to be called in the subclass constructor.
      */
    @JsonCreator
    public Residential(@JsonProperty("id") Long id, @JsonProperty("address") String address,
                       @JsonProperty("price") int price,
                       @JsonProperty("no_parking_space") int nOfParkingSpace,
                       @JsonProperty("storage_type") String storageType,
                       @JsonProperty("no_storage") int nOfStorages,
                       @JsonProperty("build_date") Date builtDate) {
        super(id, address, price);
        this.nOfParkingSpace = nOfParkingSpace;
        this.storageType = storageType;
        this.nOfStorages = nOfStorages;
        this.builtDate = builtDate;
        this.entryDate= Date.valueOf(LocalDate.now());
    }

//    /**
//     * Constructor to be called in the subclass constructor.
//     */
//
//    @JsonCreator
//    public Residential(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
//        super(id, address, price);
//        this.entryDate= Date.valueOf(LocalDate.now());
//    }

    /**
     * Check if the home is a high valued home.
     * @return ture, if the calling object is a high value home;
     */
    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    /**
     * Check if the building is a new construction at present.
     * @return true, if the building is constructed within 5 years;
     *          false, if it has been built more than 5 years.
     */
    public boolean isNew(){
        return YEARS.between(this.builtDate.toLocalDate(), LocalDate.now()) < 5;
    }

    /**
     * Set the built date of a Residential Property as the  passed LocalDate object.
     * Throw IllegalArgumentException if the input date is after today(exclusive).
     * @param d a LocalDate object to be set as the built date of a Residential object.
     *          As LocalDate is an immutable type, no need for deep copy.
     */
    public void setBuiltDate(LocalDate d) throws IllegalArgumentException{
        if (d.isAfter(entryDate.toLocalDate()))
            throw new IllegalArgumentException("Built date after today");
        else
            this.builtDate = Date.valueOf(d);
    }

    /**
     * Abstract method to be completed in subclass to return ownership type as a string
     * @return the type of ownership as a string
     */
    public abstract String getOwnership();

}
