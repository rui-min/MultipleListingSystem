package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ResidentialTest {
    UUID id1 = UUID.randomUUID();
    UUID id2 = UUID.randomUUID();
    UUID id3 = UUID.randomUUID();
    UUID id4 = UUID.randomUUID();
//    UUID id5 = UUID.randomUUID();

    String ad1 = "Yonge St 101";
    String ad2 = "Yonge St 103";
    String ad3 = "Yonge St 108";
    String ad4 = "Keele St 101";
//    String ad5 = "Keele St 114";

    LocalDate d1 = LocalDate.of(1999, 5, 1);
    LocalDate d2 = LocalDate.of(2018, 3, 21); //new construction
    LocalDate d3 = LocalDate.of(2010, 5, 1);


    @Test
    public void testBuiltDate() {
        //declared as Residential, so they can only call methods declared in the Residential class.
        Residential semi = new SemiDetached(id1, ad1, 10000);
        Residential det = new DetachedHome(id2, ad2, 150000);
        Residential dup = new MultiLex(id3, ad3, 5000000);

        assertEquals(semi.getBuiltDate(), null);
        assertTrue(det.getBuiltDate() == null);

        semi.setBuiltDate(d1);
        det.setBuiltDate(d2);
        //dup is used to test the default case

        assertEquals(semi.getBuiltDate(), d1);
        assertTrue(det.getBuiltDate() == d2);
        assertNull(dup.getBuiltDate());

        //test exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dup.setBuiltDate(LocalDate.now().plusDays(1));
        });
        String message = exception.getMessage();
        assertTrue(message.contains("Built date after today"));

        //test isNew
        assertFalse(semi.isNew());
        assertTrue(det.isNew());
    }

    @Test
    public void testParkingSpace() {
        Residential semi = new SemiDetached(id1, ad1, 10000);
        assertEquals(semi.howManyParkingSpace(), 0);//default

        semi.setParkingSpace(2);
        assertEquals(semi.howManyParkingSpace(), 2);

    }

    @Test
    public void testStorage() {
        Residential semi = new SemiDetached(id1, ad1, 10000);
        assertEquals(semi.howManyStorage(), 0);//default

        semi.setStorage("Garage", 1);
        assertEquals(semi.howManyStorage(), 1);
    }

    @Test
    public void getOwnership() {
        Residential semi = new SemiDetached(id1, ad1, 10000);
        Residential condo = new Condo(id2, ad2, 10000);
        Residential coop = new CooperativeHome(id3, ad3, 10000);

    }

    @Test
    public void getBuildingType() {
        Residential semi = new SemiDetached(id1, ad1, 10000);
        Residential condo = new Condo(id2, ad2, 10000);
        Residential coop = new CooperativeHome(id3, ad3, 10000);

        assertEquals(semi.getBuildingType(), "SemiDetached");
        assertEquals(condo.getBuildingType(), "Condo");
        assertEquals(coop.getBuildingType(), "CooperativeHome");
    }

    @Test
    public void isHighValue() {
        Residential dup = new MultiLex(id3, ad3, 5000000);
        assertTrue(dup.isHighValue());

        Residential tri = new MultiLex(id4, ad4, 700000);
        assertFalse(tri.isHighValue());
    }


    @Test
    public void testToStringAndBuilders() {
//        Residential semi = new SemiDetached(id1, ad1, 10000);
//        Residential condo = new Condo(id2, ad2, 10000);

//        Residential fh = new FarmHouse(id4, ad4, 10000);

//        semi.setStorage("Garage", 1);
//        condo.setStorage("Locker", 2);

//        //fh default
//
//        semi.setParkingSpace(1);
//        condo.setParkingSpace(2);

//        //fh default
//
//        semi.setBuiltDate(d1);
//        condo.setBuiltDate(d2);

//        //fh default
        Residential semi = new SemiDetached.Builder(id1, ad1, 10000)
                .storageTypeIs("Garage").withHowManyStorages(1).withHowManyParkingSpaces(1)
                .withHowManyStoreys(2).buildAt(d1).build();

        Residential condo = new Condo.Builder(id2, ad2, 10000).withStorageType("Locker")
                .withHowManyLockerStorage(2).withHowManyParks(2).withBuiltDate(d2).build();

        Residential coop = new CooperativeHome(id3, ad3, 10000);
        coop.setParkingSpace(3);
        coop.setStorage("Basement", 1);
        coop.setBuiltDate(d3);

        Residential fh = new FarmHouse.Builder(id4, ad4, 10000).build();
        // leave fh's other attributes as default to test the default cases.


        String semiString = semi.toString();
        String condoString = condo.toString();
        String coopString = coop.toString();
        String fhString = fh.toString();

        String semiString0 = "SemiDetached{uuid=" + id1 + ", address=" + ad1 + ", price=10000" + "}, " +
                "ownership=Freehold, " +
                "builtDate=" + d1 + ", " +
                "storageType=Garage, " +
                "numberOfStorage=1, " +
                "numberOfParkingSpace=1, " +
                "isNewConstruction=false, " +
                "isHighValue=false" +
                ", type=null, numberOfFloors=2, isMultigeneration=false";

        String condoString0 = "Condo{uuid=" + id2 + ", address=" + ad2 + ", price=10000" + "}, " +
                "ownership=Condominium, " +
                "builtDate=" + d2 + ", " +
                "storageType=Locker, " +
                "numberOfStorage=2, " +
                "numberOfParkingSpace=2, " +
                "isNewConstruction=true, " +
                "isHighValue=false" +
                ", unitNumber=0";

        String coopString0 = "CooperativeHome{uuid=" + id3 + ", address=" + ad3 + ", price=10000" + "}, " +
                "ownership=Cooperative Home, " +
                "builtDate=" + d3 + ", " +
                "storageType=Basement, " +
                "numberOfStorage=1, " +
                "numberOfParkingSpace=3, " +
                "isNewConstruction=false, " +
                "isHighValue=false";

        String fhString0 = "FarmHouse{uuid=" + id4 + ", address=" + ad4 + ", price=10000" + "}, " +
                "ownership=Freehold, " +
                "builtDate=Unknown" + ", " +
                "storageType=null, " +
                "numberOfStorage=0, " +
                "numberOfParkingSpace=0, " +
                "isNewConstruction=false, " +
                "isHighValue=false" +
                ", type=null, numberOfFloors=0, isMultigeneration=false";

        assertEquals(semiString, semiString0);
        assertEquals(condoString, condoString0);
        assertEquals(coopString, coopString0);
        assertEquals(fhString, fhString0);
    }
}