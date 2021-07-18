package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: Property (level 1)
 */
public abstract class Property {
    /**
     * "private" keyword achieves Encapsulation: below attributes are hidden to users,
     * and public setters and getters (defined further below) allow
     * clients to access and update private attributes.
     */
    private UUID uuid;
    private String address;
    private int price;

    /**
     * below constructor is written to prevent users from creating by default constructor
     */
    private Property() {}

    /**
     * The public constructor is prepared for subclasses to create a new java.model.Property with
     * given uuid, address and price.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public Property(UUID uuid, String address, int price) {
        this.uuid = uuid;
        this.address = address;
        this.price = price;
    }

    /**
     * Get the uuid of the property
     * @return uuid of the property
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Get the address of the property
     * @return address of the property
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the property
     * @param address address of the property
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the price of the property
     * @return price of the property
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the property
     * @param price price of the property
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Override Object class's equals() method. Evaluate objects' equality using attribute values
     * For simplification, it is assumed that same address represents same property regardless
     * of other attributes. Write "final" to force no subclasses' overridden.
     * @param o other Object for comparison
     * @return a boolean value "true" if specified attribute values are same, otherwise "false"
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property other = (Property) o;
        return this.address.equals(other.address);
    }

    /**
     * Override Object class's toString() method. Create a string representation of this java.model.Property
     * @return the string representation of this java.model.Property
     */
    @Override
    public String toString() {
        return String.format("%s{uuid=%s, address=%s, price=%d}",
                this.getClass().getSimpleName(), this.getUuid(), this.getAddress(), this.getPrice());
    }



    /**
     * Builder design pattern to facilitate construction of an
     * MLS record.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Design_Patterns">About Design Patterns</a>
     * @see <a href="https://en.wikipedia.org/wiki/Builder_pattern">About Builder Pattern</a>
     */
    public static class Builder {

        private UUID id;
        private String address;
        private int price;

        public Builder(UUID id) {
            this.id = id;
        }

        /**
         * Set the address of the property
         * @param address of the property
         * @return the Builder object
         */
        public Builder locatedAt(String address){
            this.address = address;
            return this;
        }

        /**
         * Set the price of the property
         * @param price of the property
         * @return the Builder object
         */
        public Builder pricedAt(int price){
            this.price = price;
            return this;
        }

        /**
         * Finalize the construction of an MLS record using Builder design pattern.
         * @return the MLS record using the previously collected information
         * provided to the Builder object.
         */
        public MultipleListingService build(){
            MultipleListingService mls = new MultipleListingService();
            mls.id = this.id;
            mls.address = this.address;
            mls.price = this.price;
            return mls;
        }
    }

    // quick test
    public static void main(String[] args) {
        Property tri = new TripleDeckers(UUID.randomUUID(),"Yonge",90000);
        System.out.println(tri);
    }
}