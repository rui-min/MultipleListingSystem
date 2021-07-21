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

//    /**
//     * default constructor is private and never called
//     */
//    private Property() {}

    /**
     * The public constructor is prepared for subclasses to create a new Property with
     * given uuid, address and price.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property
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
     * For simplification, it is assumed that same address represents same property.
     * @param o other Object for comparison
     * @return a boolean value "true" if specified attribute values are same, otherwise "false"
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property other = (Property) o;
        return this.address.equals(other.address);
    }

    //song: moved from Residential//Todo
    /**
     * Called by subclass instance.
     * @return return the concrete class name of a subclass instance.
     */
    public String getBuildingType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Override Object class's toString() method. Create a string representation of this Property
     * @return the string representation of this Property
     */
    @Override
    public String toString() {
        return String.format("%s{uuid=%s, address=%s, price=%d}",
                this.getBuildingType(), this.getUuid(), this.getAddress(), this.getPrice());
    }

    // quick test
    public static void main(String[] args) {
        Property tri = new TripleDeckers(UUID.randomUUID(),"Yonge",90000);
        System.out.println(tri);
    }
}