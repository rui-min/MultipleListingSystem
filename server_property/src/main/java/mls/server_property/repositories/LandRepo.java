package mls.server_property.repositories;

import mls.server_property.domain.Land;
import org.springframework.stereotype.Repository;

@Repository("landRepo")
public interface LandRepo extends PropertyRepo<Land>{
}
