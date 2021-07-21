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
class PropertyTest {
    /**
     * Test new methods getUuid() with concrete subclasses
     */
    @Test
    void testGetUuid() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Property tow = new TownHouse(id1,"York",1200000);
        Property tri = new TripleDeckers(id2,"Yonge",900000);
        assertEquals(id1,tow.getUuid());
        assertEquals(id2,tri.getUuid());
    }

    /**
     * Test new methods setAddress(..) and getAddress() with concrete subclasses
     */
    @Test
    void testAddress() {
        Property tow = new TownHouse(UUID.randomUUID(),"York",1200000);
        Property tri = new TripleDeckers(UUID.randomUUID(),"Yonge",900000);
        assertEquals("York",tow.getAddress());
        assertEquals("Yonge",tri.getAddress());
        tow.setAddress("Sheppard"); tri.setAddress("Hamilton");
        assertEquals("Sheppard",tow.getAddress());
        assertEquals("Hamilton",tri.getAddress());
    }

    /**
     * Test new methods setPrice(..) and getPrice() with concrete subclasses
     */
    @Test
    void testPrice() {
        Property tow = new TownHouse(UUID.randomUUID(),"York",1200000);
        Property tri = new TripleDeckers(UUID.randomUUID(),"Yonge",900000);
        assertEquals(1200000,tow.getPrice());
        assertEquals(900000,tri.getPrice());
        tow.setPrice(120); tri.setPrice(90);
        assertEquals(120,tow.getPrice());
        assertEquals(90,tri.getPrice());
    }

    /**
     * Test new methods getBuildingType() with concrete subclasses
     */
    @Test
    void testBuildingType() {
        Property tow = new TownHouse(UUID.randomUUID(),"York",1200000);
        Property tri = new TripleDeckers(UUID.randomUUID(),"Yonge",900000);
        assertEquals("TownHouse", tow.getBuildingType());
        assertEquals("TripleDeckers", tri.getBuildingType());
    }

    /**
     * Test new overridden method equals(): address is considered (other factors may be
     * considered for different subclasses)
     */
    @Test
    void testEquals() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Property tri1 = new TripleDeckers(id1,"Yonge",900000);
        Property tri2 = new TripleDeckers(id2,"Yonge",100000);
        assertEquals(tri1,tri2);
    }

    /**
     * Test new overridden method toString() with concrete subclass TripleDeckers
     * Corresponding string should begin with below format for package "MLS" manipulation
     * String.format("%s{uuid=%s, address=%s, price=%d}",
     *         this.getBuildingType(), this.getUuid(), this.getAddress(), this.getPrice());
     */
    @Test
    void testToString() {
        UUID sameID = UUID.randomUUID();
        Property tri = new TripleDeckers(sameID,"Yonge",900000);

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