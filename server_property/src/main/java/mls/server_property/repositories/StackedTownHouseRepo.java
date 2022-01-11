package mls.server_property.repositories;

import mls.server_property.domain.StackedTownHouse;
import org.springframework.stereotype.Repository;

@Repository("StackedTownHouseRepo")
public interface StackedTownHouseRepo extends CondominiumRepo<StackedTownHouse>{

}
