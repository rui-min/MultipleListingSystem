package model;


import java.time.LocalDate;
import java.util.UUID;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Abstract class representing Residential Property (level 2)
 */
public abstract class Residential extends Property implements ParkingSpaces {
    public static final int REFER_PRICE = 750000;
    private int nOfParkingSpace;
    private String storageType;
    private int nOfStorages;
    private LocalDate builtDate;
    private LocalDate entryDate; // the day the object is entered in the system

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
     * @return true, if the building is constructed with in 5 years; false, if it is built more than 5 years.
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
     * Methods from the ParkingSpace interface. Get number of parking spaces.
     * @return number of parking spaces
     */
    @Override
    public int howManyParkingSpace(){
        return this.nOfParkingSpace;
    }

    /**
     * Set number of parking spaces.
     * @param howMany number of parking spaces
     */
    @Override
    public void setParkingSpace(int howMany) {
        this.nOfParkingSpace = howMany;
    }


    public int howManyStorage(){
        return this.nOfStorages;
    }

    public void setStorage(String type, int howMany){
        this.nOfStorages = howMany;
        this.storageType = type;
    }

    public String getStorageType(){
        return this.storageType;
    }

    /**
     * Abstract method to be completed in subclass to return a String
     * @return the type of ownership in String
     */
    public abstract String getOwnership();



    /**
     *
     * @return a String representation of an subclass object.
     */
    @Override
    public String toString(){
        return String.format("%s " +
                        "ownership=%s, " +
                        "builtDate=%s, " +
                        "storageType=%s, " +
                        "numberOfStorage=%d, " +
                        "numberOfParkingSpace=%d, " +
                        "isNewConstruction=%s, " +
                        "isHighValue=%s",
                super.toString(),
                this.getOwnership(),
                this.builtDate,
                this.storageType,
                this.nOfStorages,
                this.nOfParkingSpace,
                this.isNew(),
                this.isHighValue()
            );
    }
}
