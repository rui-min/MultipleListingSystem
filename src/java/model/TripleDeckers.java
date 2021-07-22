package model;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Concrete class representing Building: Triple Deckers (level 4)
 */
public class TripleDeckers extends Condominium{

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public TripleDeckers(UUID uuid, String address, int price) {
        super(uuid, address, price);
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
        private String storageType = "Normal";  // by default "Normal"
        private LocalDate builtDate = LocalDate.MIN;

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
         * Set the storageType of the property
         * @param storageType of the property
         * @return the Builder object
         */
        public Builder withStorageType(String storageType){
            this.storageType = storageType;
            return this;
        }

        /**
         * Set the build date of the property
         * @param builtDate of the property
         * @return the Builder object
         */
        public Builder withBuiltDate(LocalDate builtDate){
            this.builtDate = builtDate;
            return this;
        }

        /**
         * Finalize the construction of TripleDeckers using Builder design pattern.
         * @return TripleDeckers using the previously collected information
         * provided to the Builder object.
         */
        public TripleDeckers build(){
            TripleDeckers tri = new TripleDeckers(this.uuid,this.address,this.price);
            tri.setUnitNumber(this.unitNumber);
            tri.setParkingSpace(this.howManyParks);
            tri.setStorage(this.storageType, this.howManyLockerStorage);
            tri.setBuiltDate(this.builtDate);
            return tri;
        }
    }


    // quick test
    public static void main(String[] args) {
        TripleDeckers tri = new TripleDeckers(UUID.randomUUID(),"Yonge",90000);
        System.out.println(tri.getBuildingType());
        System.out.println(tri);

        TripleDeckers tri1 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        System.out.println(tri1.getUnitNumber());

        TripleDeckers tri2 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",800000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
        System.out.println(tri2.getUnitNumber());
        System.out.println(tri1.equals(tri2));  // True
        System.out.println(tri1 == tri2);       // False
        System.out.println(tri2);
    }
}
