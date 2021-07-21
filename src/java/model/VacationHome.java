package model;
 /**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import java.time.LocalDate;
import java.util.UUID;

public class VacationHome extends Freehold {
    /**
     * Constructor of VacationHome
     * @param uuid
     * @param address
     * @param price
     */
    public VacationHome(UUID uuid, String address, int price) {
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
        private int nOfParkingSpace;
        private String storageType;
        private int nOfStorages;
        private LocalDate builtDate;
        private String type; // multi family or single family
        private int numberOfStoreys;
        private boolean isMultigeneration;

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
         * @param nOfParkingSpace of the property
         * @return the Builder object
         */
        public Builder withHowManyParks(int nOfParkingSpace){
            this.nOfParkingSpace = nOfParkingSpace;
            return this;
        }

        /**
         * Set the number of parks of the property
         * @param storageType of the property
         * @return the Builder object
         */
        public Builder storageTypeIs(String storageType){
            this.storageType = storageType;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param type of the property
         * @return the Builder object
         */
        public Builder typeIs(String type){
            this.type = type;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param builtDate of the property
         * @return the Builder object
         */
        public Builder buildAt(LocalDate builtDate){
            this.builtDate = builtDate;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param numberOfStoreys of the property
         * @return the Builder object
         */
        public Builder withHowManyStorages(int numberOfStoreys){
            this.numberOfStoreys = numberOfStoreys;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param nOfStorages of the property
         * @return the Builder object
         */
        public Builder withHowManStorages(int nOfStorages){
            this.nOfStorages = this.nOfStorages;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param isMultigeneration of the property
         * @return the Builder object
         */
        public Builder withHowManyLockerStorage(boolean isMultigeneration){
            this.isMultigeneration = isMultigeneration;
            return this;
        }

        /**
         * Finalize the construction of Townhouse using Builder design pattern.
         * @return Condo using the previously collected information
         * provided to the Builder object.
         */
        public VacationHome build(){
            VacationHome vh = new VacationHome(this.uuid,this.address,this.price);
            vh.setType(this.type);
            vh.setNumberOfFloors(this.numberOfStoreys);
            vh.setStorage(this.storageType,nOfStorages);
            vh.setBuiltDate(this.builtDate);
            vh.setMultigeneration(this.isMultigeneration);
            return vh;
        }
    }


}
