package mls.server_property.repositories;

import mls.server_property.domain.StackedTownHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("StackedTownHouseRepo")
public interface StackedTownHouseRepo extends JpaRepository<StackedTownHouse, Long> {

}
