package mls.server_property.repositories;

import mls.server_property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface PropertyRepo<Property> extends JpaRepository<Property , Long> {

    // Duplicate queries
    Optional<Property> findPropertyByAddress(String address);

    Optional<Property> findPropertyById(Long id);

    // Functional queries
    Optional<List<Property>> findPropertiesByPriceBetween(int lowerBound, int upperBound);

    Optional<List<Property>> findPropertiesByAddressContains(String partialAddress);
}
