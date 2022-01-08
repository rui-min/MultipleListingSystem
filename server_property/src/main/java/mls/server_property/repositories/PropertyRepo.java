package mls.server_property.repositories;

import mls.server_property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface PropertyRepo<T extends Property> extends JpaRepository<Property , Long> {

    // Duplicate queries
//    Optional<T> findPropertyByAddress(String address);
//
//    Optional<T> findPropertyById(Long id);
//
//    // Functional queries
//    Optional<List<T>> findPropertiesByPriceBetween(int lowerBound, int upperBound);
//
//    Optional<List<T>> findPropertiesByAddressContains(String partialAddress);
}
