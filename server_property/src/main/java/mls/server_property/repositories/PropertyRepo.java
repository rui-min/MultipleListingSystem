package mls.server_property.repositories;

import mls.server_property.domain.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PropertyRepo extends CrudRepository<Property, Long> {

}
