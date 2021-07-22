package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test strategy: test 2 kinds of constructions, and equals() method.
 */
class TripleDeckersTest {
    /**
     * Use normal constructor to construct objects. uuid, address and price are
     * mandatory fields.
     */
    @Test
    public void testNormalConstructor() {
        TripleDeckers tri = new TripleDeckers(UUID.randomUUID(),"Yonge",90000);
        assertEquals("Yonge",tri.getAddress());
        assertEquals(90000,tri.getPrice(), 0.01);
    }

    /**
     * Use builder to construct objects. If some parts are not assembled, default values will
     * be set.
     */
    @Test
    public void testBuilderConstructor() {
        TripleDeckers tri1 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        assertEquals(101,tri1.getUnitNumber(), 0.01);
        assertEquals(0, tri1.howManyParkingSpace(), 0.01);
        assertEquals(0, tri1.howManyStorage(), 0.01);
        assertEquals(-999999999, tri1.getBuiltDate().getYear(), 0.01);

        TripleDeckers tri2 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",800000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3)
                .withBuiltDate(LocalDate.of(1990,1,1)) .build();
        assertEquals(101,tri2.getUnitNumber(), 0.01);
        assertEquals(2, tri2.howManyParkingSpace(), 0.01);
        assertEquals(3, tri2.howManyStorage(), 0.01);
        assertEquals(1990, tri2.getBuiltDate().getYear(), 0.01);
    }

    /**
     * Condominium type properties are equal only when both addresses and unit numbers are equal
     */
    @Test
    public void testEquals() {
        TripleDeckers tri1 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(101) .build();
        TripleDeckers tri2 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",5000)
                .withUnitNumber(101).withHowManyParks(2).withHowManyLockerStorage(3) .build();
        TripleDeckers tri3 = new TripleDeckers.Builder(UUID.randomUUID(),"Yonge",90000)
                .withUnitNumber(202) .build();
        assertEquals(tri1, tri2);
        assertNotEquals(tri1, tri3);
    }

}