package mls.server_property.model;


import java.time.LocalDate;
import java.util.UUID;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Abstract class representing Residential Property (level 2)
 */
public abstract class Residential extends Property implements ParkingSpaces, Storage {
    /**
     * The reference price used to decide whether a home is high value.
     */
    public static final int REFER_PRICE = 750000;

    private   int         nOfParkingSpace;
    private   String      storageType;
    private   int         nOfStorages;
    private   LocalDate   builtDate = LocalDate.MIN;
    private   LocalDate   entryDate; // the day on which the object is entered in the system

    /**
     * Constructor to be called in the subclass constructor.
     * @param uuid UUID for the new object
     * @param address address of the new residential property
     * @param price price of the new residential property
     */
    public Residential(UUID uuid, String address, int price) {
        super(uuid, address, price);
        this.entryDate = LocalDate.now();
    }

    /**
     * Check if the home is a high valued home.
     * @return ture, if the calling object is a high value home;
     */
    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    /**
     * Check if the building is a new construction at present.
     * @return true, if the building is constructed within 5 years; false, if it has been built more than 5 years.
     */
    public boolean isNew(){
        return YEARS.between(this.builtDate, LocalDate.now()) < 5;
    }

    /**
     * Set the built date of a Residential Property as the  passed LocalDate object.
     * Throw IllegalArgumentException if the input date is after today(exclusive).
     * @param d a LocalDate object to be set as the built date of a Residential object.
     *          As LocalDate is an immutable type, no need for deep copy.
     */
    public void setBuiltDate(LocalDate d) throws IllegalArgumentException{
        if (d.isAfter(entryDate))
            throw new IllegalArgumentException("Built date after today");
        else
            this.builtDate = d;
    }

    /**
     * Get the built date of a Residential Property
     * @return built date of the residential property
     */
    public LocalDate getBuiltDate() {
        return this.builtDate;
    }

    /**
     * Methods from the ParkingSpace interface. Get number of parking spaces.
     * @return number of parking spaces
     */
    public int howManyParkingSpace(){
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
    public int howManyStorage(){
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
                this.builtDate != LocalDate.MIN? this.builtDate : "Unknown",
                this.storageType,
                this.nOfStorages,
                this.nOfParkingSpace,
                this.isNew(),
                this.isHighValue()
            );
    }


}
