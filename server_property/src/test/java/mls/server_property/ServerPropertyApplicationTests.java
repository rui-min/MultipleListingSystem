package mls.server_property;

import mls.server_property.domain.*;
import mls.server_property.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes=ServerPropertyApplication.class)
class ServerPropertyApplicationTests {
    @Autowired
    LandRepo ldRepo;
    @Autowired
    VacationHomeRepo vhRepo;

	@Test
	void businessLogicTest() {
        assertEquals(6,vhRepo.count());
        assertEquals(6,ldRepo.count());

        Optional<List<Land>> optList1= ldRepo.findByAddressContainsAndPriceBetween("18",100,100000000);
        assertEquals("Land{id=2, address='zab918', price=100000, buildingType='Land'}",
                        optList1.get().get(1).toString());

        Optional<List<VacationHome>> optList2= vhRepo.findBynOfParkingSpace(2);
        assertEquals("Property{id=14, address='zab936', price=100000, buildingType='VacationHome'}, ownership=null, builtDate=1900-01-01, storageType=above, numberOfStorage=1, numberOfParkingSpace=2, isNewConstruction=false, isHighValue=false, type=recommended, numberOfFloors=null, isMultigeneration=false",
                        optList2.get().get(0).toString());
	}

}
