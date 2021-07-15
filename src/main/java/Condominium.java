import java.util.UUID;
/**
 * Abstract class representing Condominium Type (level 3)
 */
public abstract class Condominium extends Residential implements LockerStorage {
    private final String TITLE = "Condominium";
    private int unitNumber = -1;

    public Condominium(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public String getTITLE() {
        return TITLE;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public abstract int howManyLockerStorage();
    public abstract void setHowManyLockerStorage(int howManyLockerStorage);
}
