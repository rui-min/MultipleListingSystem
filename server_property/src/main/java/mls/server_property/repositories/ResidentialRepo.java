package mls.server_property.repositories;

<<<<<<< Updated upstream
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ResidentialRepo extends PropertyRepo{

=======
import mls.server_property.domain.Residential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentialRepo extends JpaRepository<Residential, Long> {
>>>>>>> Stashed changes
}
