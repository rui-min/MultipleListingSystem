package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test strategy: test 2 kinds of constructions, and override equals() method.
 */
class StackedTownHouseTest {
    /**
     * Use normal constructor to construct objects. uuid, address and price are
     * mandatory fields.
     */
    @Test
    public void testNormalConstructor() {
        StackedTownHouse sta = new StackedTownHouse(UUID.randomUUID(),"Yonge",90000);
        assertEquals("Yonge",sta.getAddress());
        assertEquals(90000,sta.getPrice(), 0.01);
    }

    /**
     * Use builder to construct objects. If some parts are not assembled, default values will
     * be set.
     */
    @Test
    public void testBuilderConstructor() {
        StackedTownHouse sta1 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        assertEquals(101,sta1.getUnitNumber(), 0.01);
        assertEquals(0, sta1.howManyParkingSpace(), 0.01);
        assertEquals(0, sta1.howManyStorage(), 0.01);
        assertEquals(-999999999, sta1.getBuiltDate().getYear(), 0.01);

        StackedTownHouse sta2 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",800000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3)
                .withBuiltDate(LocalDate.of(1990,1,1)) .build();
        assertEquals(101,sta2.getUnitNumber(), 0.01);
        assertEquals(2, sta2.howManyParkingSpace(), 0.01);
        assertEquals(3, sta2.howManyStorage(), 0.01);
        assertEquals(1990, sta2.getBuiltDate().getYear(), 0.01);
    }

    /**
     * Condominium type properties are equal only when both addresses and unit numbers are equal
     */
    @Test
    public void testEquals() {
        StackedTownHouse sta1 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        StackedTownHouse sta2 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",5000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
        StackedTownHouse sta3 = new StackedTownHouse.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(202) .build();
        assertEquals(sta1, sta2);
        assertNotEquals(sta1, sta3);
    }

}