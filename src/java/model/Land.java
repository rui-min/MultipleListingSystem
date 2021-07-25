package model;

import MLS.mlsRecord;

import java.util.UUID;

/**
 * Concrete class representing listed vacant land (level 2)
 */
public class Land extends Property {

    /**
     * Subclass constructor must call superclass's non-private constructor for inheritance.
     * @param uuid    the unique uuid of the property
     * @param address the unique address of the property, with unit No. if applicable
     * @param price   an initial price set to the listing property
     */
    public Land(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

//    print test
//    public static void main(String[] args){
//        Land a = new Land(UUID.randomUUID(), "20 ABC", 2000);
//        System.out.println(a.toString());
//        System.out.println(mlsRecord.fromClass(a.toString()));
//    }
}