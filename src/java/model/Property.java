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
     * builder.uuid is the unique uuid of the property
     * builder.address is the unique address of the property, with unit No. if applicable
     * builder.price is selling price of the listed property
     * @param builder
     */
    public <T extends Builder<T>> Property(Builder<?> builder) {
        this.uuid = builder.uuid;
        this.address = builder.address;
        this.price = builder.price;
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
     * Builder design pattern to facilitate construction of the class
     * "abstract" for abstract class.
     */
    public static abstract class Builder<T extends Builder <T>> {

        private UUID uuid;
        private String address;
        private int price;

        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * Set the address of the property
         * @param address of the property
         * @return the Builder object
         */
        public T locatedAt(String address){
            this.address = address;
            return (T) this;
        }

        /**
         * Set the price of the property
         * @param price of the property
         * @return the Builder object
         */
        public T pricedAt(int price){
            this.price = price;
            return (T) this;
        }

        /**
         * Finalize the construction of an MLS record using Builder design pattern.
         * @return the MLS record using the previously collected information
         * provided to the Builder object.
         */
        public abstract T build(); // TODO by concrete subclasses

    }

    // quick test
    public static void main(String[] args) {
        Property tri = new TripleDeckers(UUID.randomUUID(),"Yonge",90000);
        System.out.println(tri);
    }
}