package mls.server_property.repositories;

import mls.server_property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@NoRepositoryBean
@Repository
public interface PropertyRepo<T extends Property> extends JpaRepository<T, Long> {

    // Duplicate queries
    @Query("select p from property p where p.address = ?1")
    Optional<T> findPropertyByAddress(String address);

    @Query("select p from property p where p.id = ?1")
    Optional<T> findPropertyById(Long id);

    // Functional queries
    @Query("select p from property p where 'property_type' like '%type%' and p.price between ?1 and ?2")
    Optional<List<T>> findPropertiesByPriceBetween(int lowerBound, int upperBound, String type);



    Optional<List<T>> findPropertiesByAddressContains(String partialAddress);


}
