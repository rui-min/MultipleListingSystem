package model;
import java.util.UUID;

/**
 * Concrete class representing Building: Condo (level 4)
 */
public class Condo extends Condominium {
    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Condo(UUID uuid, String address, int price) {
        super(uuid, address, price);
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
        Condo other = (Condo) o;
        return this.getAddress().equals(other.getAddress())
                && this.getUnitNumber() == other.getUnitNumber();
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
        private String storageType;

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
         * Finalize the construction of Condo using Builder design pattern.
         * @return Condo using the previously collected information
         * provided to the Builder object.
         */
        public Condo build(){
            Condo condo = new Condo(this.uuid,this.address,this.price);
            condo.setUnitNumber(this.unitNumber);
            condo.setParkingSpace(this.howManyParks);
            condo.setStorage(this.storageType,this.howManyLockerStorage);
            return condo;
        }
    }


    // quick test
    public static void main(String[] args) {
        Condo condo = new Condo(UUID.randomUUID(),"Yonge",90000);
//        System.out.println(condo.getTITLE());
        System.out.println(condo); System.out.println("===============================");

        Condo condo1 = new Condo.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        System.out.println(condo1.getUnitNumber());
        System.out.println(condo1); System.out.println("===============================");

        Condo condo2 = new Condo.Builder(UUID.randomUUID(),"Yonge",800000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
        System.out.println(condo2.getUnitNumber());
        System.out.println(condo2); System.out.println("===============================");

        System.out.println(condo1.equals(condo2));  // True
        System.out.println(condo1 == condo2);       // False

    }
}
