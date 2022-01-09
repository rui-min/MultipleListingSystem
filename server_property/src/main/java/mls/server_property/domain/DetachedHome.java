package mls.server_property.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Concrete class representing Detached Home (level 4)
 */



    @Entity
    @Table
    public class DetachedHome extends Freehold {

        //    empty constructor for hibernate
        protected DetachedHome() {
            super();
        }

        public DetachedHome(@JsonProperty("address") String address, @JsonProperty("price") int price) {
            super(address, price);
        }

        @Id
        @SequenceGenerator(
                name = "detachedHome_sequence",
                sequenceName = "detachedHome_sequence",
                allocationSize = 1  //question: 1?
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detachedHome_sequence")
        private Long id;
        private String address;
        private int price;



//    Question: should I use uuid and inheritance of super here?
//    super is freehold by Song, residential is by Min
        /**
         * Construct a new VacationHome given its id, address and price.
         *
         * @param uuid    the unique id of the new DetachedHome.
         * @param address the address of the new DetachedHome.
         * @param price   the price of the new DetachedHome.
         */
        public DetachedHome(Long uuid, String address, int price) {
            super(address, price);
        }


        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public Long getId() {
            return id;
        }

        @Override
        public String getAddress() {
            return address;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "VacationHome{" +
                    "address='" + address + '\'' +
                    ", price=" + price +
                    '}';
        }


        /**
         * This is a inner class served as a Builder of DetachedHome objects
         */
        public static class Builder {

            private Long uuid;
            private String address;
            private int price;
            private int nOfParkingSpace;
            private String storageType;
            private int nOfStorages;
            private LocalDate builtDate = LocalDate.MIN;
            private int numberOfStoreys;
            private boolean isMultigeneration;
            private int nOfUnits;

            /**
             * Builder constructor with three mandatory attributes: uuid, address, price
             *
             * @param uuid    the unique uuid of the Property object
             * @param address the unique address of the Property object
             * @param price   selling price of the listed Property object
             */
            public Builder(Long uuid, String address, int price) {
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
            public mls.server_property.domain.DetachedHome.Builder withHowManyParkingSpaces(int nOfParkingSpace) {
                this.nOfParkingSpace = nOfParkingSpace;
                return this;
            }

            /**
             * Set the storage type of the property
             *
             * @param storageType of the property
             * @return the Builder object
             */
            public mls.server_property.domain.DetachedHome.Builder storageTypeIs(String storageType) {
                this.storageType = storageType;
                return this;
            }

            /**
             * Set the built date of the home
             *
             * @param builtDate of the property
             * @return the Builder object
             */
            public mls.server_property.domain.DetachedHome.Builder buildAt(LocalDate builtDate) {
                this.builtDate = builtDate;
                return this;
            }

            /**
             * Set the number of storeys of the freehold property
             *
             * @param numberOfStoreys of the freehold property
             * @return the Builder object
             */
            public mls.server_property.domain.DetachedHome.Builder withHowManyStoreys(int numberOfStoreys) {
                this.numberOfStoreys = numberOfStoreys;
                return this;
            }

            /**
             * Set the number of storages of the property
             *
             * @param nOfStorages of the property
             * @return the Builder object
             */
            public mls.server_property.domain.DetachedHome.Builder withHowManStorages(int nOfStorages) {
                this.nOfStorages = nOfStorages;
                return this;
            }

            /**
             * Set whether the home can be multi-generational.
             *
             * @param isMultigeneration of the property
             * @return the Builder object
             */
            public mls.server_property.domain.DetachedHome.Builder isMultigeneration(boolean isMultigeneration) {
                this.isMultigeneration = isMultigeneration;
                return this;
            }

            /**
             * Specify how many units are there in the MultiLex object the builder is going to build.
             *
             * @param n number of units in the DetachedHome.
             */
            public mls.server_property.domain.DetachedHome.Builder withUnits(int n) {
                this.nOfUnits = n;
                return this;
            }

            /**
             * Finalize the construction of a DetachedHome.
             *
             * @return MultiLex using the previously collected information
             * provided to the Builder object.
             */
            public mls.server_property.domain.DetachedHome build() {
                mls.server_property.domain.DetachedHome detach = new mls.server_property.domain.DetachedHome(this.uuid, this.address, this.price);
                detach.setNumberOfFloors(this.numberOfStoreys);
                detach.setStorage(this.storageType, nOfStorages);
                detach.setBuiltDate(this.builtDate);
                detach.setMultigeneration(this.isMultigeneration);
                detach.setParkingSpace(this.nOfParkingSpace);
                return detach;
            }
        }
    }  // end class
