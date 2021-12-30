package mls.server_property.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Concrete class representing Semi-detached home (level 4)
 */
public class SemiDetached extends Freehold {
    public SemiDetached(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


    /**
     * This is a inner class served as a Builder of SemiDetached objects
     */
    public static class Builder {

        private UUID uuid;
        private String address;
        private int price;
        private int nOfParkingSpace;
        private String storageType;
        private int nOfStorages;
        private LocalDate builtDate = LocalDate.MIN;
        private int numberOfStoreys;
        private boolean isMultigeneration;


        /**
         * Builder constructor with three mandatory attributes: uuid, address, price
         *
         * @param uuid    the unique uuid of the Property object
         * @param address the unique address of the Property object
         * @param price   selling price of the listed Property object
         */
        public Builder(UUID uuid, String address, int price) {
            this.uuid = uuid;
            this.address = address;
            this.price = price;
        }

        /**
         * Set the number of parking spaces of the home.
         *
         * @param nOfParkingSpace of the home.
         * @return the Builder object
         */
        public Builder withHowManyParkingSpaces(int nOfParkingSpace) {
            this.nOfParkingSpace = nOfParkingSpace;
            return this;
        }

        /**
         * Set the storage type of the property
         *
         * @param storageType of the property
         * @return the Builder object
         */
        public Builder storageTypeIs(String storageType) {
            this.storageType = storageType;
            return this;
        }

        /**
         * Set the built date of the home
         *
         * @param builtDate of the property
         * @return the Builder object
         */
        public Builder buildAt(LocalDate builtDate) {
            this.builtDate = builtDate;
            return this;
        }

        /**
         * Set the number of storeys of the freehold property
         *
         * @param numberOfStoreys of the freehold property
         * @return the Builder object
         */
        public Builder withHowManyStoreys(int numberOfStoreys) {
            this.numberOfStoreys = numberOfStoreys;
            return this;
        }

        /**
         * Set the number of storages of the property
         *
         * @param nOfStorages of the property
         * @return the Builder object
         */
        public Builder withHowManyStorages(int nOfStorages) {
            this.nOfStorages = nOfStorages;
            return this;
        }

        /**
         * Set whether the home can be multi-generational.
         *
         * @param isMultigeneration of the property
         * @return the Builder object
         */
        public Builder isMultigeneration(boolean isMultigeneration) {
            this.isMultigeneration = isMultigeneration;
            return this;
        }

        /**
         * Finalize the construction of a SemiDetached home.
         *
         * @return SemiDetached object using the previously collected information
         * provided to the Builder object.
         */
        public SemiDetached build() {
            SemiDetached semiDetached = new SemiDetached(this.uuid, this.address, this.price);
            semiDetached.setNumberOfFloors(this.numberOfStoreys);
            semiDetached.setStorage(this.storageType, this.nOfStorages);
            semiDetached.setBuiltDate(this.builtDate);
            semiDetached.setMultigeneration(this.isMultigeneration);
            semiDetached.setParkingSpace(this.nOfParkingSpace);
            return semiDetached;
        }
   }
}
