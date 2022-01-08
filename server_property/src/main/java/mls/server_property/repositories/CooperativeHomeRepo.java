package mls.server_property.repositories;

import mls.server_property.domain.CooperativeHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeHomeRepo extends JpaRepository<CooperativeHome, Long> {
}
