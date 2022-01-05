package mls.server_property.repositories;

import mls.server_property.domain.Property;
<<<<<<< Updated upstream
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PropertyRepo extends CrudRepository<Property, Long> {

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {
>>>>>>> Stashed changes
}
