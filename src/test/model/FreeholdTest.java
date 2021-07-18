package model;

import org.junit.Test;

import model.FarmHouse;
import model.Freehold;
import model.TownHouse;
import model.VacationHome;
import java.util.UUID;

import static org.junit.Assert.*;

public class FreeholdTest {
    @Test
    public void test01() {
        Freehold f1 = new TownHouse(UUID.randomUUID(),"Yonge", 500000);
        Freehold f2 = new VacationHome(UUID.randomUUID(),"Finch", 400000);
        Freehold f3 = new FarmHouse(UUID.randomUUID(), "North York", 300000) {
        };
        f1.setHowManyGenerations(3);
        f2.setHowManyParks(2);
        assertEquals(3,f1.getHowManyGenerations());
        assertEquals(2,f2.getHowManyParks());
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());

    }

    @Test
    public void setHowManyGenerations() {
    }

    @Test
    public void testToString() {
    }
}