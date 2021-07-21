package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test strategy for abstract class: test all methods created or overridden in this class.
 * There may be duplicated tests for methods overridden in subclasses. But it is safe to do
 * the tests here as well.
 */
class CondominiumTest {
    /**
     * Test owner type method getOwnership()
     */
    @Test
    public void testOwnerType() {
        Condominium tri = new TripleDeckers(UUID.randomUUID(),"Yonge",900000);
        Condominium condo = new Condo(UUID.randomUUID(),"York",100000);
        Condominium sta = new StackedTownHouse(UUID.randomUUID(),"Sheppard",500000);
        assertEquals("Condominium", tri.getOwnership());
        assertEquals("Condominium", condo.getOwnership());
        assertEquals("Condominium", sta.getOwnership());
    }

    /**
     * Test new methods setUnitNumber(..) and getUnitNumber()
     */
    @Test
    public void testUnitNumber() {
        Condominium tri = new TripleDeckers(UUID.randomUUID(),"Yonge",900000);
        Condominium condo = new Condo(UUID.randomUUID(),"York",100000);
        Condominium sta = new StackedTownHouse(UUID.randomUUID(),"Sheppard",500000);
        tri.setUnitNumber(101); condo.setUnitNumber(101);sta.setUnitNumber(2003);
        assertEquals(101, tri.getUnitNumber());
        assertEquals(101, condo.getUnitNumber());
        assertEquals(2003, sta.getUnitNumber());
    }

    /**
     * Test new overridden method equals(): only address and unit number are considered
     */
    @Test
    public void testEquals() {
        Condominium tri1 = new TripleDeckers(UUID.randomUUID(),"Yonge",900000);
        Condominium tri2 = new TripleDeckers(UUID.randomUUID(),"Yonge",100000);
        tri1.setUnitNumber(101); tri2.setUnitNumber(101);
        assertEquals(tri1,tri2);
    }

    /**
     * Test new overridden method toString() with concrete subclass TripleDeckers
     * Corresponding string should begin with below format for package "MLS" manipulation
     * String.format("%s{uuid=%s, address=%s, price=%d}",
     *         this.getBuildingType(), this.getUuid(), this.getAddress(), this.getPrice());
     */
    @Test
    public void testToString() {
        UUID sameID = UUID.randomUUID();
        Condominium tri = new TripleDeckers(sameID,"Yonge",900000);

        String[] subs_tri = tri.toString().split("[{]", 2);
        subs_tri[1] = subs_tri[1].replaceAll("[{]}", "");
        String name = subs_tri[0];
        ArrayList<String> msg_tri = new ArrayList<>();
        for(String field: subs_tri[1].split(", ", 4))
            msg_tri.add(field.split("=")[1]);
        assertEquals("TripleDeckers",name);
        assertEquals(sameID.toString(),msg_tri.get(0));
        assertEquals("Yonge",msg_tri.get(1));
        assertTrue(msg_tri.get(2).startsWith("900000"));
        
    }
}