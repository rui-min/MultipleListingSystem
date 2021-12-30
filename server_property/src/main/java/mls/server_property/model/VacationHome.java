package mls.server_property.model;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */
import java.time.LocalDate;
import java.util.UUID;

public class VacationHome extends Freehold {

    public VacationHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

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
        private int numberOfFloors;
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
         * @param numberOfFloors of the property
         * @return the Builder object
         */
        public Builder hasHowManyFloors(int numberOfFloors){
            this.numberOfFloors = numberOfFloors;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param nOfStorages of the property
         * @return the Builder object
         */
        public Builder hasHowManyStorages(int nOfStorages){
            this.nOfStorages = nOfStorages;
            return this;
        }
        /**
         * Set the number of parks of the property
         * @param isMultigeneration of the property
         * @return the Builder object
         */
        public Builder hasGenerations(boolean isMultigeneration){
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
            vh.setNumberOfFloors(this.numberOfFloors);
            vh.setStorage(this.storageType,nOfStorages);
            vh.setBuiltDate(this.builtDate);
            vh.setMultigeneration(this.isMultigeneration);
            vh.setParkingSpace(nOfParkingSpace);
            return vh;
        }

    }

}
