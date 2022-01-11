package mls.server_property;

import mls.server_property.domain.*;
import mls.server_property.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=ServerPropertyApplication.class)
class ServerPropertyApplicationTests {
    @Autowired
    VacationHomeRepo vacationHomeRepo;


	@Test
	void contextLoads() {
//      Land l1 = new Land(1L,"a", 1000000);
//      Land l2 = new Land(2L,"b", 1100000);
//      Land l3 = new Land(3L,"c", 1100000);
//      Land l4 = new Land(4L,"d", 1100000);
      VacationHome v1 = new VacationHome(null, "a", 1111111, 0, null, 0, null, null, 0, false);
      vacationHomeRepo.save(v1);
//      landRepo.save(l1);
//      landRepo.save(l2);
//      landRepo.save(l3);
//      landRepo.save(l4);
//      long i = vacationHomeRepo.count();
//      long j = landRepo.count();
      long k = 0;
      System.out.println(vacationHomeRepo.findByAddress("a"));
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
