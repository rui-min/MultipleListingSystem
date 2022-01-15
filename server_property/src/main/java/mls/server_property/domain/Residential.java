package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

@Entity
//@DiscriminatorColumn(name="r_type")
//@DiscriminatorValue("r")
//@Table(name="residential")
public abstract class Residential extends Property {
    /**
     * The reference price used to decide whether a home is high value.
     */
    public static final int REFER_PRICE = 750000;

    // !! Must be wrapper class "Integer" instead of "int" because DB by default assigns null
    @Column(name="no_parking_space")
    private   Integer     nOfParkingSpace;
    @Column(name="storage_type")
    private   String      storageType;
    @Column(name="no_storage")
    private   Integer     nOfStorages;
    @Column(name="build_date")
    private   Date   builtDate = Date.valueOf("1900-1-1");
    @Column(name="entry_date")
    private   Date   entryDate; // the day on which the object is entered in the system
    @Column(name = "is_high_value")
    private   Boolean isHighValue;
    @Column(name = "is_new")
    private   Boolean isNew;

    protected Residential(){super();}       // empty constructor a must

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
        if (builtDate!=null) {
            this.builtDate = builtDate;
        }
        this.entryDate= Date.valueOf(LocalDate.now());
        this.isHighValue = this.getPrice() >= REFER_PRICE;
        this.isNew = builtDate != null && YEARS.between(this.builtDate.toLocalDate(), LocalDate.now()) < 5;
    }

    public Boolean isHighValue() {
        return isHighValue;
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
        this.isHighValue = this.getPrice() >= REFER_PRICE;
    }

    public Boolean isNew() {
        return isNew;
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
        else {
            this.builtDate = Date.valueOf(d);
            this.isNew = YEARS.between(this.builtDate.toLocalDate(), LocalDate.now()) < 5;
        }
    }

    /**
     * Get the built date of a Residential Property
     * @return built date of the residential property
     */
    public Date getBuiltDate() {
        return this.builtDate;
    }

    /**
     * Methods from the ParkingSpace interface. Get number of parking spaces.
     * @return number of parking spaces
     */
    public Integer howManyParkingSpace(){
        return this.nOfParkingSpace;
    }

    /**
     * Set number of parking spaces.
     * @param howMany number of parking spaces
     */
    public void setParkingSpace(int howMany) {
        this.nOfParkingSpace = howMany;
    }

    /**
     * Get the number of storages attached to this home.
     * @return number of storages of the calling Residential object.
     */
    public Integer howManyStorage(){
        return this.nOfStorages;
    }

    /**
     * Set the storage type and amounts.
     * @param type tyoe of the storages, e.g. Locker, Garage, Basement, etc.
     * @param howMany how many storages are there in this home.
     */
    public void setStorage(String type, int howMany){
        this.nOfStorages = howMany;
        this.storageType = type;
    }

    /**
     * Get the storage type of the home.
     * @return a string indicating the type of storage.
     */
    public String getStorageType(){
        return this.storageType;
    }

    /**
     * Abstract method to be completed in subclass to return ownership type as a string
     * @return the type of ownership as a string
     */
    public abstract String getOwnership();



    /**
     * Return the string representation of the calling object.
     * @return a String representation
     */
    @Override
    public String toString(){
        return String.format("%s, " +
                        "ownership=%s, " +
                        "builtDate=%s, " +
                        "storageType=%s, " +
                        "numberOfStorage=%d, " +
                        "numberOfParkingSpace=%d, " +
                        "isNewConstruction=%s, " +
                        "isHighValue=%s",
                super.toString(),
                this.getOwnership(),
                this.builtDate != Date.valueOf("1900-1-1")? this.builtDate : "Unknown",
                this.storageType,
                this.nOfStorages,
                this.nOfParkingSpace,
                this.isNew(),
                this.isHighValue()
            );
    }


}
