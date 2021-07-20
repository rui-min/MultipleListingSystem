package model;
import java.util.UUID;

/**
 * Concrete class representing Building: Stacked Townhouse (level 4)
 */
public class StackedTownHouse extends Condominium {
    /**
     * final constant attribute representing current class's unique title in the format
     * "superclass's TITLE - current class's TITLE"
     */
    private final String TITLE = super.getTITLE() + " - " + this.getClass().getSimpleName();

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public StackedTownHouse(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    /**
     * Get TITLE of current class. Override superclass's same method.
     * @return TITLE of current class
     */
    @Override
    public String getTITLE() {
        return TITLE;
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
        StackedTownHouse other = (StackedTownHouse) o;
        return this.getAddress().equals(other.getAddress())
                && this.getUnitNumber() == other.getUnitNumber();
    }

    /**
     * Override superclass's toString() method. Create a string representation of current class
     * @return the string representation of current class
     */
    @Override
    public String toString() {
        return "StackedTownHouse{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", howManyParks=" + getHowManyParks() +
                ", unitNumber=" + getUnitNumber() +
                ", howManyLockerStorage=" + getHowManyLockerStorage() +
                ", TITLE='" + TITLE + '\'' +
                '}';
    }

    /**
     * Builder design pattern to facilitate construction of current class object
     */
    public static class Builder {
        /**
         * below are mandatory attributes
         */
        private UUID uuid;
        private String address;
        private int price;

        /**
         * below are optional attributes
         */
        private int unitNumber;
        private int howManyParks;
        private int howManyLockerStorage;

        /**
         * Builder constructor with three mandatory attributes: uuid, address, price
         * @param uuid the unique uuid of the property
         * @param address the unique address of the property
         * @param price selling price of the listed property
         */
        public Builder(UUID uuid, String address, int price) {
            this.uuid = uuid;
            this.address = address;
            this.price = price;
        }

        /**
         * Set the unit number of the property
         * @param unitNumber of the property
         * @return the Builder object
         */
        public Builder withUnitNumber(int unitNumber){
            this.unitNumber = unitNumber;
            return this;
        }

        /**
         * Set the number of parks of the property
         * @param howManyParks of the property
         * @return the Builder object
         */
        public Builder withHowManyParks(int howManyParks){
            this.howManyParks = howManyParks;
            return this;
        }

        /**
         * Set the number of parks of the property
         * @param howManyLockerStorage of the property
         * @return the Builder object
         */
        public Builder withHowManyLockerStorage(int howManyLockerStorage){
            this.howManyLockerStorage = howManyLockerStorage;
            return this;
        }

        /**
         * Finalize the construction of StackedTownHouse using Builder design pattern.
         * @return StackedTownHouse using the previously collected information
         * provided to the Builder object.
         */
        public StackedTownHouse build(){
            StackedTownHouse sta = new StackedTownHouse(this.uuid,this.address,this.price);
            sta.setUnitNumber(this.unitNumber);
            sta.setHowManyParks(this.howManyParks);
            sta.setHowManyLockerStorage(this.howManyLockerStorage);
            return sta;
        }
    }


    // quick test
    public static void main(String[] args) {
        StackedTownHouse sta = new StackedTownHouse(UUID.randomUUID(),"Yonge",90000);
        System.out.println(sta.getTITLE());
        System.out.println(sta);

        StackedTownHouse sta1 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        System.out.println(sta1.getUnitNumber());

        StackedTownHouse sta2 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",800000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
        System.out.println(sta2.getUnitNumber());
        System.out.println(sta1.equals(sta2));  // True
        System.out.println(sta1 == sta2);       // False
        System.out.println(sta2);
    }
}
