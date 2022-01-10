//package mls.server_property;
//
//import mls.server_property.domain.Land;
//import mls.server_property.domain.VacationHome;
//import mls.server_property.repositories.LandRepo;
//import mls.server_property.repositories.VacationHomeRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest(classes=ServerPropertyApplication.class)
//class ServerPropertyApplicationTests {
//    @Autowired
//    VacationHomeRepo vacationHomeRepo;
//    @Autowired
//    LandRepo landRepo;
//
//	@Test
//	void contextLoads() {
//      Land l1 = new Land(1L,"a", 1000000);
//      Land l2 = new Land(2L,"b", 1100000);
//      Land l3 = new Land(3L,"c", 1100000);
//      Land l4 = new Land(4L,"d", 1100000);
//      VacationHome v1 = new VacationHome(null, "a", 1111111, 0, null, 0, null, null, 0, false);
//      vacationHomeRepo.save(v1);
//      landRepo.save(l1);
//      landRepo.save(l2);
//      landRepo.save(l3);
//      landRepo.save(l4);
//      long i = vacationHomeRepo.count();
//      long j = landRepo.count();
//      long k = 0;
//	}
//
//}
