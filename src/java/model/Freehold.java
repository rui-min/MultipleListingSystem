package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: java.model.Freehold type (level 3)
 */
public abstract class Freehold extends Residential implements Generations {

    /**
     * "private" keyword achieves Encapsulation: below attributes are hidden to users,
     * and public setters and getters (defined further below) allow
     * clients to access and update private attributes.
     */
    private int numberOfFloors = 0;
    private int howManyGenerations = 1;


    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price selling price of the listed property
     */
    public <T extends Builder<T>> Freehold(Builder<?> builder) {
        super(builder);
        this.numberOfFloors = builder.numberOfFloors;
        this.howManyGenerations = builder.howManyGenerations;
    }

    /**
     * Get the number of floors
     * @return number of floors
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Set the number of floors
     * @param numberOfFloors the number of floors
     */
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * override the abstract method in Generation interface
     * get howManyGenerations in this house
     * @return the number of generations living here.
     */
    @Override
    public int getHowManyGenerations() {
        return this.howManyGenerations;
    }

    /**
     * override the abstract method in Generation interface.
     * Set howManyGenerations in this house
     * @param howManyGenerations the number of generations living here.
     */
    @Override
    public void setHowManyGenerations(int howManyGenerations){
        this.howManyGenerations = howManyGenerations;
    };


    /**
     * Override superclass's toString() method. Create a string representation of this class.
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return "Freehold{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", numberOfFloors=" + numberOfFloors +
                ", howManyGenerations=" + howManyGenerations +
                '}';
    }


    public static abstract class Builder<T extends Builder<T>>
            extends Residential.Builder<Builder<T>> {

        private int numberOfFloors;
        private int howManyGenerations;

        public Builder(UUID uuid) {
            super(uuid);
        }

        public T numberOfFloors(int numberOfFloors){
            this.numberOfFloors = numberOfFloors;
            return (T) this;
        }

        public T howManyGenerations(int howManyGenerations){
            this.howManyGenerations = howManyGenerations;
            return (T) this;
        }


        public abstract T build(); // TODO by concrete subclasses

    }

}
