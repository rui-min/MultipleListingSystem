package mls.server_property.domain;
/**
 * Concrete class representing Farm House (level 4)
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("Property_Residential_Freehold_FarmHouse")
public class FarmHouse extends Freehold {
//    public FarmHouse(Long uuid, String address, int price) {
//        super(address, price);
//    }


//    public static class Builder {
//        /**
//         * below are mandatory attributes
//         */
//        private Long uuid;
//        private String address;
//        private int price;
//
//        /**
//         * below are optional attributes
//         */
//        private int nOfParkingSpace;
//        private String storageType;
//        private int nOfStorages;
//        private LocalDate builtDate = LocalDate.MIN;
//        private String type; // multi family or single family
//        private int numberOfStoreys;
//        private boolean isMultigeneration;
//        private int numberOfFloors;
//
//        /**
//         * Builder constructor with three mandatory attributes: uuid, address, price
//         *
//         * @param uuid    the unique uuid of the property
//         * @param address the unique address of the property
//         * @param price   selling price of the listed property
//         */
//        public Builder(Long uuid, String address, int price) {
//            this.uuid = uuid;
//            this.address = address;
//            this.price = price;
//        }
//
//        /**
//         * Set the unit number of the property
//         *
//         * @param nOfParkingSpace of the property
//         * @return the Builder object
//         */
//        public Builder withHowManyParks(int nOfParkingSpace) {
//            this.nOfParkingSpace = nOfParkingSpace;
//            return this;
//        }
//
//        /**
//         * Set the number of parks of the property
//         *
//         * @param storageType of the property
//         * @return the Builder object
//         */
//        public Builder storageTypeIs(String storageType) {
//            this.storageType = storageType;
//            return this;
//        }
//
//        /**
//         * Set the number of parks of the property
//         *
//         * @param type of the property
//         * @return the Builder object
//         */
//        public Builder typeIs(String type) {
//            this.type = type;
//            return this;
//        }
//
//        /**
//         * Set the number of parks of the property
//         *
//         * @param builtDate of the property
//         * @return the Builder object
//         */
//        public Builder buildAt(LocalDate builtDate) {
//            this.builtDate = builtDate;
//            return this;
//        }
//
//        /**
//         * Set the number of parks of the property
//         *
//         * @param numberOfFloors of the property
//         * @return the Builder object
//         */
//        public Builder hasHowManyFloors(int numberOfFloors) {
//            this.numberOfFloors = numberOfFloors;
//            return this;
//        }
//
//        /**
//         * Set the number of parks of the property
//         *
//         * @param nOfStorages of the property
//         * @return the Builder object
//         */
//        public Builder hasHowManyStorages(int nOfStorages) {
//            this.nOfStorages = nOfStorages;
//            return this;
//        }
//
//        /**
//         * Set the number of parks of the property
//         *
//         * @param isMultigeneration of the property
//         * @return the Builder object
//         */
//        public Builder hasGenerations(boolean isMultigeneration) {
//            this.isMultigeneration = isMultigeneration;
//            return this;
//        }
//
//        /**
//         * Finalize the construction of Townhouse using Builder design pattern.
//         *
//         * @return Condo using the previously collected information
//         * provided to the Builder object.
//         */
//        public FarmHouse build() {
//            FarmHouse fh = new FarmHouse(this.uuid, this.address, this.price);
//            fh.setType(this.type);
//            fh.setNumberOfFloors(this.numberOfFloors);
//            fh.setStorage(this.storageType, nOfStorages);
//            fh.setBuiltDate(this.builtDate);
//            fh.setMultigeneration(this.isMultigeneration);
//            fh.setParkingSpace(nOfParkingSpace);
//            return fh;
//        }
//
//    }

    }