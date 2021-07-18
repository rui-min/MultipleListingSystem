package model;

import java.util.UUID;

/**
 * Abstract class is a class that cannot be made instances of in Java and it helps
 * achieve Abstraction.
 * This abstract class represents the idea: java.model.Condominium type (level 3)
 */
public abstract class Condominium extends Residential implements LockerStorage {
    private int unitNumber = 0;
    private int howManyLockerStorage = 0;

    public <T extends Builder<T>> Condominium(Builder<?> builder) {
        super(builder);
        this.unitNumber = builder.unitNumber;
        this.howManyLockerStorage = builder.howManyLockerStorage;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getHowManyLockerStorage() {
        return this.howManyLockerStorage;
    };
    public void setHowManyLockerStorage(int howManyLockerStorage) {
        this.howManyLockerStorage = howManyLockerStorage;
    };

    @Override
    public String toString() {
        return "Condominium{" +
                "uuid=" + getUuid() +
                ", address='" + getAddress() + '\'' +
                ", price=" + getPrice() +
                ", REFER_PRICE=" + REFER_PRICE +
                ", highValue=" + isHighValue() +
                ", unitNumber=" + unitNumber +
                ", howManyLockerStorage=" + howManyLockerStorage +
                '}';
    }


    public static abstract class Builder<T extends Builder<T>>
            extends Residential.Builder<Builder<T>> {

        private int unitNumber;
        private int howManyLockerStorage;

        public Builder(UUID uuid) {
            super(uuid);
        }

        public T unitNumber(int unitNumber){
            this.unitNumber = unitNumber;
            return (T) this;
        }

        public T howManyLockerStorage(int howManyLockerStorage){
            this.howManyLockerStorage = howManyLockerStorage;
            return (T) this;
        }

        public abstract T build(); // TODO by concrete subclasses

    }

}
