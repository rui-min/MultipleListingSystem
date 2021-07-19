package model;

import java.time.LocalDate;
import java.util.UUID;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Abstract class representing Residential Type (level 2)
 */
public abstract class Residential extends Property implements ParkingSpaces, Storage {
    public static final int REFER_PRICE = 750000;
    private int nOfParkingSpace;
    private String storageType;
    private int nOfStorages;
    private LocalDate builtDate;
    private LocalDate entryDate; // the day the object is entered in the system

    /**
     * Constructor to be called in the subclass constructor.
     * @param uuid
     * @param address
     * @param price
     */
    public Residential(UUID uuid, String address, int price) {
        super(uuid, address, price);
        this.entryDate = LocalDate.now();
    }

    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    /**
     * Check if the building is a new construction at present.
     * @return true, if the building is constructed with in 5 years; false, if it is built more than 5 years.
     */
    public boolean isNew(){
        if (YEARS.between(this.builtDate, LocalDate.now()) >= 5)
            return false;
        else
            return true;

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



    @Override
    public int howManyParkingSpace(){
        return this.nOfParkingSpace;
    }

    @Override
    public void setParkingSpace(int howMany) {
        this.nOfParkingSpace = howMany;
    }


    @Override
    public int howManyStorage(){
        return this.nOfStorages;
    }

    @Override
    public void setStorage(String type, int howMany){
        this.nOfStorages = howMany;
        this.storageType = type;
    }

    @Override
    public String getStorageType(){
        return this.storageType;
    }

    public abstract String getOwnership();

    /**
     * Called by subclass instance.
     * @return return the concrete class name of a subclass instance.
     */
    public String getBuildingType() {
        return this.getClass().getSimpleName();
    }

    /**
     *
     * @return a String representation of an subclass object.
     */
    @Override
    public String toString(){
        return String.format("%s{" +
                        "uuid=%s, " +
                        "address=%s, " +
                        "price=%d, " +
                        "ownership=%s, " +
                        "builtDate=%s" +
                        "storageType=%s" +
                        "numberOfStorage=%d" +
                        "numberOfParkingSpace=%d" +
                        "isNewConstruction=%s",
                this.getClass().getSimpleName(),
                this.getUuid(),
                this.getAddress(),
                this.getPrice(),
                this.getOwnership(),
                this.builtDate,
                this.storageType,
                this.nOfStorages,
                this.nOfParkingSpace,
                this.isNew());

    }
}
