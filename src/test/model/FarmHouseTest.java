package model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class FarmHouseTest{
    /**
     * Tests for methods in Residential
     */
    @Test
    public void test01(){

        FarmHouse f = new FarmHouse(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        f.setBuiltDate(date);
        f.setParkingSpace(2);
        f.setMultigeneration(true);
        assertEquals(true,f.isMultigeneration());
        assertEquals(2,f.howManyParkingSpace());
        assertEquals(false, f.isNew());
        assertEquals(false, f.isHighValue());
        System.out.println(f.toString());
    }

    @Test
    public void test02(){
        FarmHouse f = new FarmHouse(UUID.randomUUID(),"Finch", 800000);
        LocalDate date = LocalDate.of(2022,11,9);
        boolean thrown = false;
        try {
            f.setBuiltDate(date);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
        assertEquals(true, f.isHighValue());


    }

    /**
     * Tests for methods in Freehold
     */
    @Test
    public void test03(){

        FarmHouse f = new FarmHouse(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        f.setType("Townhouse");
        f.setNumberOfFloors(3);
        assertEquals("Townhouse",f.getType());
        assertEquals(3, f.getNumberOfFloors());


//        System.out.println(f.toString());
    }
    /**
     * Tests for methods in interfaces
     */
    @Test
    public void test04(){

        FarmHouse  f = new FarmHouse(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        f.setStorage("Toy",1);
        f.setParkingSpace(2);
        f.setMultigeneration(true);
        assertEquals(1,f.howManyStorage());
        assertEquals(2, f.howManyParkingSpace());
        assertEquals(true, f.isMultigeneration());

//        System.out.println(f.toString());
    }
    /**
     * Tests for builder pattern for TownHouse
     */
    @Test
    public void test05(){

        FarmHouse.Builder b = new FarmHouse.Builder(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        b.hasHowManyStorages(1).hasHowManyFloors(2).withHowManyParks(1)
                .buildAt(date).typeIs("Townhouse").hasGenerations(true).hasHowManyFloors(2);
        FarmHouse f = b.build();
        assertEquals(1,f.howManyStorage());
        assertEquals(1, f.howManyParkingSpace());
        assertEquals(2, f.getNumberOfFloors());
        assertEquals(true, f.isMultigeneration());
        assertEquals("Townhouse", f.getType());

//        System.out.println(t3.toString());
    }

}