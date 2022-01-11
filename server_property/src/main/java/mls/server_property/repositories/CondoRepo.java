package mls.server_property.repositories;

import mls.server_property.domain.Condo;
import org.springframework.stereotype.Repository;

@Repository("CondoRepo")
public interface CondoRepo extends CondominiumRepo<Condo>{
}
