package mls.server_property;

import mls.server_property.domain.*;
import mls.server_property.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes=ServerPropertyApplication.class)
class ServerPropertyApplicationTests {
    @Autowired
    VacationHomeRepo vhRepo;
    @Autowired
    LandRepo ldRepo;

	@Test
	void contextLoads() {
//        Land l1 = new Land(null,"az", 1000);
//        Land l2 = new Land(2L,"zb", 1100000);
//        Land l3 = new Land(3L,"cz", 1100000);
//        Land l4 = new Land(4L,"zd", 1100000);
        VacationHome v1 = new VacationHome(null, "a", 1111111, 0, null, 0, null, null, 0, false);
        vhRepo.save(v1);
//        ldRepo.save(l1);
//        ldRepo.save(l2);
//        ldRepo.save(l3);
//        ldRepo.save(l4);
//        long i = vhRepo.count();
//        long j = ldRepo.count();
//        long k = 0;
//        Optional<List<Land>> optList1= ldRepo.findByAddressContainsAndPriceBetween("z",100,100000000);
//        System.out.println(optList.get().get(1));
        Optional<List<VacationHome>> optList3= vhRepo.findByBuiltDate(Date.valueOf("12"));
	}

}
