package mls.server_property.repositories;

import mls.server_property.domain.MobileHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MobileHomeRepo extends JpaRepository<MobileHome, Long> {

}
