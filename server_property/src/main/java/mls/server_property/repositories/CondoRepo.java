package mls.server_property.repositories;

import mls.server_property.domain.Condo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondoRepo extends JpaRepository<Condo, Long> {
    List<Condo> findByAddress(String address);
}
