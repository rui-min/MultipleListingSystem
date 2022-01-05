package mls.server_property.repositories;

import mls.server_property.domain.TripleDeckers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripleDeckersRepo extends JpaRepository<TripleDeckers, Long>{

    boolean findByAddress(boolean b);
}
