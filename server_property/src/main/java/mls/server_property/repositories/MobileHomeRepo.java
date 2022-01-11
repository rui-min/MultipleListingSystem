package mls.server_property.repositories;

import mls.server_property.domain.MobileHome;
import org.springframework.stereotype.Repository;

@Repository("mobileHomeRepo")
public interface MobileHomeRepo extends ResidentialRepo<MobileHome> {

}
