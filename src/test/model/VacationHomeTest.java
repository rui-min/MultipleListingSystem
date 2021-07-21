package model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


public class VacationHomeTest {
    /**
     * Tests for methods in Residential
     */
    @Test
    public void test01(){

        VacationHome v = new VacationHome(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        v.setBuiltDate(date);
        v.setParkingSpace(2);
        v.setMultigeneration(true);
        assertEquals(true,v.isMultigeneration());
        assertEquals(2,v.howManyParkingSpace());
        assertEquals(false, v.isNew());
        assertEquals(false, v.isHighValue());
        System.out.println(v.toString());
    }

    @Test
    public void test02(){

        VacationHome v = new VacationHome(UUID.randomUUID(),"Finch", 800000);
        LocalDate date = LocalDate.of(2022,11,9);
        boolean thrown = false;
        try {
            v.setBuiltDate(date);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
        assertEquals(true, v.isHighValue());


    }

    /**
     * Tests for methods in Freehold
     */
    @Test
    public void test03(){

        VacationHome v = new VacationHome(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        v.setType("Townhouse");
        v.setNumberOfFloors(3);
        assertEquals("Townhouse",v.getType());
        assertEquals(3, v.getNumberOfFloors());

//        System.out.println(t3.toString());
    }
    /**
     * Tests for methods in interfaces
     */
    @Test
    public void test04(){

        VacationHome v = new VacationHome(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        v.setStorage("Toy",1);
        v.setParkingSpace(2);
        v.setMultigeneration(true);
        assertEquals(1,v.howManyStorage());
        assertEquals(2, v.howManyParkingSpace());
        assertEquals(true, v.isMultigeneration());

//        System.out.println(v.toString());
    }
    /**
     * Tests for builder pattern for TownHouse
     */
    @Test
    public void test05(){

        VacationHome.Builder b = new VacationHome.Builder(UUID.randomUUID(),"Finch", 400000);
        LocalDate date = LocalDate.of(2005,11,9);
        b.hasHowManyStorages(1).hasHowManyFloors(2).withHowManyParks(1)
                .buildAt(date).typeIs("VacationHome").hasGenerations(true).hasHowManyFloors(2);
        VacationHome v = b.build();
        assertEquals(1,v.howManyStorage());
        assertEquals(1, v.howManyParkingSpace());
        assertEquals(2, v.getNumberOfFloors());
        assertEquals(true, v.isMultigeneration());
        assertEquals("VacationHome", v.getType());
//        System.out.println(t3.toString());
    }

}

