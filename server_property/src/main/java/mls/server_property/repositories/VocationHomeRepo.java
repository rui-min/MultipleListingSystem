package mls.server_property.repositories;

import mls.server_property.domain.VacationHome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocationHomeRepo extends CrudRepository<VacationHome, Long> {

}