import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: Freehold type (level 3)
 */
public abstract class Freehold extends Residential implements Generations {

    /**
     * "private" keyword achieves Encapsulation: below attributes are hidden to users,
     * and public setters and getters (defined further below) allow
     * clients to access and update private attributes.
     */
    private String type = "single family";
    private int numberOfFloors = 0;
    private final String TITLE = "Freehold";

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Freehold(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * Get the type of the Freehold
     * @return type of the Freehold
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the Freehold
     * @param type of the Freehold
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the final attribute TITLE
     * @return TITLE of the Freehold
     */
    public String getTITLE() {
        return TITLE;
    }

    /**
     * Get the number of floors
     * @return number of floors
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Set the number of floors
     * @param numberOfFloors the number of floors
     */
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * An abstract method, which cannot be finished here and must be implemented
     * by non-abstract subclass.
     * @return the number of parking spaces.
     */
    public abstract int getHowManyGenerations();

    /**
     * An abstract method, which cannot be finished here and must be implemented
     * by non-abstract subclass.
     * @param howManyGenerations the number of parking spaces.
     */
    public abstract void setHowManyGenerations(int howManyGenerations);

    /**
     * Override superclass's toString() method. Create a string representation of this class.
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return "Freehold{" +
                "type='" + type + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", TITLE='" + TITLE + '\'' +
                ", uuid=" + super.getUuid() +
                ", address='" + super.getAddress() + '\'' +
                ", price=" + super.getPrice() +
                ", REFER_PRICE=" + Residential.REFER_PRICE +
                ", highValue=" + super.isHighValue() +
                '}';
    }
}
