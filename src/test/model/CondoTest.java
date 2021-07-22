package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test strategy: test 2 kinds of constructions, and equals() method.
 */
class CondoTest {
    /**
     * Use normal constructor to construct objects. uuid, address and price are
     * mandatory fields.
     */
    @Test
    public void testNormalConstructor() {
        Condo condo = new Condo(UUID.randomUUID(),"Yonge",90000);
        assertEquals("Yonge",condo.getAddress());
        assertEquals(90000,condo.getPrice(), 0.01);
    }

    /**
     * Use builder to construct objects. If some parts are not assembled, default values will
     * be set.
     */
    @Test
    public void testBuilderConstructor() {
        Condo condo1 = new Condo.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        assertEquals(101,condo1.getUnitNumber(), 0.01);
        assertEquals(0, condo1.howManyParkingSpace(), 0.01);
        assertEquals(0, condo1.howManyStorage(), 0.01);
        assertEquals(-999999999, condo1.getBuiltDate().getYear(), 0.01);

        Condo condo2 = new Condo.Builder(UUID.randomUUID(),"Yonge",800000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3)
                .withBuiltDate(LocalDate.of(1990,1,1)) .build();
        assertEquals(101,condo2.getUnitNumber(), 0.01);
        assertEquals(2, condo2.howManyParkingSpace(), 0.01);
        assertEquals(3, condo2.howManyStorage(), 0.01);
        assertEquals(1990, condo2.getBuiltDate().getYear(), 0.01);
    }

    /**
     * Condominium type properties are equal only when both addresses and unit numbers are equal
     */
    @Test
    public void testEquals() {
        Condo condo1 = new Condo.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        Condo condo2 = new Condo.Builder(UUID.randomUUID(),"Yonge",5000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
        Condo condo3 = new Condo.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(202) .build();
        assertEquals(condo1, condo2);
        assertNotEquals(condo1, condo3);
    }

}