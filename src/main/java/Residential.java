import java.util.Date;
import java.util.UUID;
/**
 * Abstract class representing Residential Type (level 2)
 */
public abstract class Residential extends Property implements ParkingSpaces, Storage {
    public static final int REFER_PRICE = 750000;
//    private Period availability;
    private int nOfParkingSpace;
    private String storageType;
    private int nOfStorages;
    private Date builtDate;


    public Residential(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    public boolean isNew(){//Todo
        return false;
    }

    public void setBuiltDate(Date d){ //Todo
        this.builtDate = new Date(d.getTime());
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

}
