//import java.time.Period;
import java.util.UUID;
/**
 * Abstract class representing Residential Type (level 2)
 */
public abstract class Residential extends Property implements ParkingSpaces {
    public static final int REFER_PRICE = 10000000;
//    private Period availability;

    public Residential(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    public abstract int getHowManyParks();

    public abstract void setHowManyParks(int howManyParks);

    @Override
    public String toString() {
        return "Residential{" +
                "uuid=" + super.getUuid() +
                ", address='" + super.getAddress() + '\'' +
                ", price=" + super.getPrice() +
                ", highValue=" + this.isHighValue() +
                '}';
    }
}
