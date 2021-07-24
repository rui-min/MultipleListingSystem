package model;
/**
 * Concrete class representing Detached Home (level 4)
 */
import java.time.LocalDate;
import java.util.UUID;


public class DetachedHome extends Freehold {

    /**
     * Construct a new DatachedHome given its UUID, address and price.
     * @param uuid the unique id of the new DatachedHome
     * @param address the address of the new DatachedHome
     * @param price the price of the new DatachedHome
     */
    public DetachedHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


    /**
     * This is a inner class served as a Builder of DatachedHome
     */
    public static class Builder {

        private UUID uuid;
        private String address;
        private int price;
        private int nOfParkingSpace;
        private String storageType;
        private int nOfStorages;
        private LocalDate builtDate = LocalDate.MIN;
        private String type; // multi family or single family
        private int numberOfStoreys;
        private boolean isMultigeneration;

        /**
         * Builder constructor with three mandatory attributes: uuid, address, price
         * @param uuid the unique uuid of the Property object
         * @param address the unique address of the Property object
         * @param price selling price of the listed Property object
         */
        public Builder(UUID uuid, String address, int price) {
            this.uuid = uuid;
            this.address = address;
            this.price = price;
        }

        /**
         * Set the number of parking spaces of the home
         * @param nOfParkingSpace of the property
         * @return the Builder object
         */
        public Builder withHowManyParkingSpaces(int nOfParkingSpace){
            this.nOfParkingSpace = nOfParkingSpace;
            return this;
        }

        /**
         * Set the storage type of the property
         * @param storageType of the property
         * @return the Builder object
         */
        public Builder storageTypeIs(String storageType){
            this.storageType = storageType;
            return this;
        }

        /**
         * Set the type of the freehold home
         * @param type of the freehold home, single family or multi-family.
         * @return the Builder object
         */
        public Builder typeIs(String type){
            this.type = type;
            return this;
        }

        /**
         * Set the built date of the home
         * @param builtDate of the property
         * @return the Builder object
         */
        public Builder buildAt(LocalDate builtDate){
            this.builtDate = builtDate;
            return this;
        }

        /**
         * Set the number of storeys of the freehold property
         * @param numberOfStoreys of the freehold property
         * @return the Builder object
         */
        public Builder withHowManyStoreys(int numberOfStoreys){
            this.numberOfStoreys = numberOfStoreys;
            return this;
        }

        /**
         * Set the number of storages of the property
         * @param nOfStorages of the property
         * @return the Builder object
         */
        public Builder withHowManStorages(int nOfStorages){
            this.nOfStorages = nOfStorages;
            return this;
        }

        /**
         * Set whether the home can be multi-generational.
         * @param isMultigeneration of the property
         * @return the Builder object
         */
        public Builder isMultigeneration(boolean isMultigeneration){
            this.isMultigeneration = isMultigeneration;
            return this;
        }

        /**
         * Finalize the construction of a DetachedHome.
         * @return DetachedHome using the previously collected information
         * provided to the Builder object.
         */
        public DetachedHome build(){
            DetachedHome det = new DetachedHome(this.uuid,this.address,this.price);
            det.setType(this.type);
            det.setNumberOfFloors(this.numberOfStoreys);
            det.setStorage(this.storageType,nOfStorages);
            det.setBuiltDate(this.builtDate);
            det.setMultigeneration(this.isMultigeneration);
            det.setParkingSpace(this.nOfParkingSpace);
            return det;
        }
    }



}