package mls.server_property;

import mls.server_property.domain.*;
import mls.server_property.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes=ServerPropertyApplication.class)
class ServerPropertyApplicationTests {
    // Avoid reporting no bean error for pRepo
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    PropertyRepo<Property> pRepo;

    @Autowired
    LandRepo ldRepo;

    @Autowired
    VacationHomeRepo vhRepo;

	@Test
	void contextLoads() {
        Land l1 = new Land(1L,"a", 1000000);
        Land l2 = new Land(2L,"b", 1100000);
        Land l3 = new Land(3L,"c", 1100000);
        Land l4 = new Land(4L,"d", 1100000);
        VacationHome v1 = new VacationHome(null, "a", 1111111, 1, null, 0, null, null, 0, false);
        vhRepo.save(v1);
        ldRepo.save(l1);
        ldRepo.save(l2);
        ldRepo.save(l3);
        ldRepo.save(l4);
        long i = vhRepo.count();
        long j = ldRepo.count();
        //below query did not return a unique result: should protect this in service file
//        System.out.println(vhRepo.findByAddress("a"));
        System.out.println(vhRepo.count());
        System.out.println(ldRepo.count());

        System.out.println(pRepo.findAll());

        Optional<List<Land>> optList1= ldRepo.findByAddressContainsAndPriceBetween("z",100,100000000);
        System.out.println(optList1.get().get(1));

        Optional<List<VacationHome>> optList2= vhRepo.findBynOfParkingSpace(1);
        System.out.println(optList2.get().get(0));

	}

}
