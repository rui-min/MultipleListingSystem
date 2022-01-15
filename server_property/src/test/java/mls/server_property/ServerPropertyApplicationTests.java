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
    @Autowired
    MultiLexRepo mlRepo;
    @Autowired
    StackedTownHouseRepo stRepo;

	@Test
	void contextLoads() {
        Land l1 = new Land(null,"ezza", 10000);
        Land l2 = new Land(null,"b", 110000);
        VacationHome v1 = new VacationHome(null, "bza", 1111111, 1, null, 0, null, null, 0, false);
        VacationHome v2 = new VacationHome(null, "edf", 1111, 1, "small", 1, null, null, 3, true);
        ldRepo.save(l1);
        ldRepo.save(l2);
        vhRepo.save(v1);
        vhRepo.save(v2);
        MultiLex m1 = new MultiLex(null, "bza", 111111, 1, "small", 1, null, null, 3, true);
        mlRepo.save(m1);
        StackedTownHouse st1= new StackedTownHouse(null,"zef",221111,1,null,2,null,4);
        StackedTownHouse st2= new StackedTownHouse(null,"abc",321111,1,null,2,null,7);
        StackedTownHouse st3= new StackedTownHouse(null,"ezez",821111,1,null,2,null,4);
        stRepo.save(st1);
        stRepo.save(st2);
        stRepo.save(st3);
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
