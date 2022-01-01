
package mls.server_property.model; /**
 * Concrete class representing MultiLex (level 4)
 */
import java.time.LocalDate;

public class MultiLex extends Freehold {

    private int nOfUnits;

    /**
     * Construct a new MultiLex given its Long, address and price.
     *
     * @param uuid    the unique id of the new MultiLex.
     * @param address the address of the new MultiLex.
     * @param price   the price of the new MultiLex.
     */
    public MultiLex(Long uuid, String address, int price) {
        super(uuid, address, price);
        this.setType("Multi-family");
    }

    /**
     * Specify how many units are there in this MultiLex.
     *
     * @param n number of units in this MultiLex.
     */
    public void setUnits(int n) {
        this.nOfUnits = n;
    }

    @Override
    public String getBuildingType() {

        switch (this.nOfUnits) {
            case 2:
                return "Duplex";
            case 3:
                return "Triplex";
            case 4:
                return "Quadriplex";
            default:
                return "Multiplex (>4)";
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", howManyUnits=" + nOfUnits;
    }


    /**
     * This is a inner class served as a Builder of MultiLex objects
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
        public Builder withHowManStorages(int nOfStorages) {
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
         * Specify how many units are there in the MultiLex object the builder is going to build.
         *
         * @param n number of units in the MultiLex.
         */
        public Builder withUnits(int n) {
            this.nOfUnits = n;
            return this;
        }

        /**
         * Finalize the construction of a MultiLex.
         *
         * @return MultiLex using the previously collected information
         * provided to the Builder object.
         */
        public MultiLex build() {
            MultiLex mul = new MultiLex(this.uuid, this.address, this.price);
            mul.setNumberOfFloors(this.numberOfStoreys);
            mul.setStorage(this.storageType, nOfStorages);
            mul.setBuiltDate(this.builtDate);
            mul.setMultigeneration(this.isMultigeneration);
            mul.setParkingSpace(this.nOfParkingSpace);
            mul.nOfUnits = this.nOfUnits;
            return mul;
        }
    }
}
