package mls.server_property.domain;
/**
 * Concrete class representing Recreational and vacation home (level 3)
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class VacationHome extends Freehold {

    //    empty constructor for hibernate
    protected VacationHome() {
        super();
    }

    public VacationHome(@JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(address, price);
    }

        @Id
        @SequenceGenerator(
                name = "semiDetached_sequence",
                sequenceName = "semiDetached_sequence",
                allocationSize = 1  //question: 1?
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semiDetached_sequence")
        private Long id;
        private String address;
        private int price;



//    Question: should I use uuid and inheritance of super here?
//    super is freehold by Song, residential is by Min
        /**
         * Construct a new VacationHome given its id, address and price.
         *
         * @param uuid    the unique id of the new VacationHome.
         * @param address the address of the new VacationHome.
         * @param price   the price of the new VacationHome.
         */
        public VacationHome(Long uuid, String address, int price) {
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
         * This is a inner class served as a Builder of VacationHome objects
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
            public mls.server_property.domain.VacationHome.Builder withHowManyParkingSpaces(int nOfParkingSpace) {
                this.nOfParkingSpace = nOfParkingSpace;
                return this;
            }

            /**
             * Set the storage type of the property
             *
             * @param storageType of the property
             * @return the Builder object
             */
            public mls.server_property.domain.VacationHome.Builder storageTypeIs(String storageType) {
                this.storageType = storageType;
                return this;
            }

            /**
             * Set the built date of the home
             *
             * @param builtDate of the property
             * @return the Builder object
             */
            public mls.server_property.domain.VacationHome.Builder buildAt(LocalDate builtDate) {
                this.builtDate = builtDate;
                return this;
            }

            /**
             * Set the number of storeys of the freehold property
             *
             * @param numberOfStoreys of the freehold property
             * @return the Builder object
             */
            public mls.server_property.domain.VacationHome.Builder withHowManyStoreys(int numberOfStoreys) {
                this.numberOfStoreys = numberOfStoreys;
                return this;
            }

            /**
             * Set the number of storages of the property
             *
             * @param nOfStorages of the property
             * @return the Builder object
             */
            public mls.server_property.domain.VacationHome.Builder withHowManStorages(int nOfStorages) {
                this.nOfStorages = nOfStorages;
                return this;
            }

            /**
             * Set whether the home can be multi-generational.
             *
             * @param isMultigeneration of the property
             * @return the Builder object
             */
            public mls.server_property.domain.VacationHome.Builder isMultigeneration(boolean isMultigeneration) {
                this.isMultigeneration = isMultigeneration;
                return this;
            }

            /**
             * Specify how many units are there in the MultiLex object the builder is going to build.
             *
             * @param n number of units in the MultiLex.
             */
            public mls.server_property.domain.VacationHome.Builder withUnits(int n) {
                this.nOfUnits = n;
                return this;
            }

            /**
             * Finalize the construction of a MultiLex.
             *
             * @return MultiLex using the previously collected information
             * provided to the Builder object.
             */
            public mls.server_property.domain.VacationHome build() {
                mls.server_property.domain.VacationHome vacat = new mls.server_property.domain.VacationHome(this.uuid, this.address, this.price);
                vacat.setNumberOfFloors(this.numberOfStoreys);
                vacat.setStorage(this.storageType, nOfStorages);
                vacat.setBuiltDate(this.builtDate);
                vacat.setMultigeneration(this.isMultigeneration);
                vacat.setParkingSpace(this.nOfParkingSpace);
                return vacat;
            }
        }
    }  // end class



