package mls.server_property;

import mls.server_property.domain.Land;
import mls.server_property.repositories.LandRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=ServerPropertyApplication.class)
class ServerPropertyApplicationTests {
    @Autowired
    LandRepo lr;
	@Test
	void contextLoads() {
        Land lr1 = new Land(1L,"a", 1000000);
        Land lr2 = new Land(2L,"b", 1100000);
        Land lr3 = new Land(3L,"c", 1100000);
        Land lr4 = new Land(4L,"d", 1100000);
        lr.save(lr1);
        lr.save(lr2);
        lr.save(lr3);
        lr.save(lr4);
        lr.delete(lr2);
	}

}
