package mls.server_property.repositories;

import mls.server_property.domain.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominumRepo extends JpaRepository<Condominium, Long> {
}
