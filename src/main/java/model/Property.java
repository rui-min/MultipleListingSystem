package model;

import java.util.UUID;
/**
 * Abstract class representing the idea: Property (level 1)
 */
public abstract class Property {
    private UUID uuid;
    private String address;
    private int price;

    /**
     * below constructor is written to prevent users from creating by default constructor
     */
    private Property() {}

    /**
     *
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price an initial price set to the listing property
     */
    public Property(UUID uuid, String address, int price) {
        this.uuid = uuid;
        this.address = address;
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Property other = (Property) o;
        return this.address.equals(other.address);
    }

}