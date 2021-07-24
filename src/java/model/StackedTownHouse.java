package model;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Concrete class representing Building: Stacked Townhouse (level 4)
 */
public class StackedTownHouse extends Condominium {

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
        private LocalDate builtDate = LocalDate.MIN;

        /**
         * Set the storageType of the property
         * @param storageType of the property
         * @return the Builder object
         */
        public Builder storageTypeIs(String storageType){
            this.storageType = storageType;
            return this;
        }

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
         * Set the build date of the property
         * @param builtDate of the property
         * @return the Builder object
         */
        public Builder withBuiltDate(LocalDate builtDate) {
            this.builtDate = builtDate;
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
            sta.setParkingSpace(this.howManyParks);
            sta.setStorage(this.storageType, this.howManyLockerStorage);
            sta.setBuiltDate(this.builtDate);
            return sta;
        }
    }


//    // quick test
//    public static void main(String[] args) {
//        StackedTownHouse sta = new StackedTownHouse(UUID.randomUUID(),"Yonge",90000);
//        System.out.println(sta.getBuildingType());
//        System.out.println(sta);
//
//        StackedTownHouse sta1 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",90000)
//                .withUnitNumber(101) .build();
//        System.out.println(sta1.getUnitNumber());
//
//        StackedTownHouse sta2 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",800000)
//                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
//        System.out.println(sta2.getUnitNumber());
//        System.out.println(sta1.equals(sta2));  // True
//        System.out.println(sta1 == sta2);       // False
//        System.out.println(sta2);
//    }
}
