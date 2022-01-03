package mls.server_property;

import mls.server_property.model.VacationHome;
import mls.server_property.repository.vhRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerPropertyApplicationTests {
    @Autowired vhRepo vhRepo;
	@Test
	void contextLoads() {
	    VacationHome vh1 = new VacationHome("a", 1000000);
      VacationHome vh2 = new VacationHome("b", 1100000);
      VacationHome vh3 = new VacationHome("c", 1100000);
      VacationHome vh4 = new VacationHome("d", 1100000);
      vhRepo.save(vh1);
      vhRepo.save(vh2);
      vhRepo.save(vh3);
      vhRepo.save(vh4);

	}

}
