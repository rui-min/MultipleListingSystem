package mls.server_property;

import mls.server_property.domain.Land;
import mls.server_property.repositories.LandRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerPropertyApplicationTests {
	@Autowired
	LandRepo lr;
	@Test
	void contextLoads() {
		Land land1 = new Land(123L,"a",100000);
		Land land2 = new Land(123L,"b",100000);
		Land land3 = new Land(123L,"c",100000);
		Land land4 = new Land(123L,"d",100000);
		lr.save(land1);
		lr.save(land2);
		lr.save(land3);
		lr.save(land4);
		lr.delete(land2);
	}

}
