package mls.server_property.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TownHouseTest {
    /**
     * Tests for methods in Residential
     */
    @Test
    public void test01(){

        TownHouse t1 = new TownHouse(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        t1.setBuiltDate(date);
        t1.setParkingSpace(2);
        t1.setMultigeneration(true);
        assertEquals(true,t1.isMultigeneration());
        assertEquals(2,t1.howManyParkingSpace());
        assertEquals(false, t1.isNew());
        assertEquals(false, t1.isHighValue());
        System.out.println(t1.toString());
    }

    @Test
    public void test02(){

        TownHouse t2 = new TownHouse(UUID.randomUUID(),"Finch", 800000);
        LocalDate date = LocalDate.of(2022,11,9);
        boolean thrown = false;
        try {
            t2.setBuiltDate(date);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        Assert.assertTrue(thrown);
        assertEquals(true, t2.isHighValue());


    }

    /**
     * Tests for methods in Freehold
     */
    @Test
    public void test03(){

        TownHouse t3 = new TownHouse(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        t3.setType("Townhouse");
        t3.setNumberOfFloors(3);
        assertEquals("Townhouse",t3.getType());
        assertEquals(3, t3.getNumberOfFloors());

//        System.out.println(t3.toString());
    }
    /**
     * Tests for methods in interfaces
     */
    @Test
    public void test04(){

        TownHouse t3 = new TownHouse(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        t3.setStorage("Toy",1);
        t3.setParkingSpace(2);
        t3.setMultigeneration(true);
        assertEquals(1,t3.howManyStorage());
        assertEquals(2, t3.howManyParkingSpace());
        assertEquals(true, t3.isMultigeneration());

//        System.out.println(t3.toString());
    }
    /**
     * Tests for builder pattern for TownHouse
     */
    @Test
    public void test05(){

        TownHouse.Builder b = new TownHouse.Builder(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        b.hasHowManyStorages(1).hasHowManyFloors(2).withHowManyParks(1)
            .buildAt(date).typeIs("Townhouse").hasGenerations(true).hasHowManyFloors(2);
        TownHouse t = b.build();
        assertEquals(1,t.howManyStorage());
        assertEquals(1, t.howManyParkingSpace());
        assertEquals(2, t.getNumberOfFloors());
        assertEquals(true, t.isMultigeneration());
        assertEquals("Townhouse", t.getType());
//        System.out.println(t3.toString());
    }

}