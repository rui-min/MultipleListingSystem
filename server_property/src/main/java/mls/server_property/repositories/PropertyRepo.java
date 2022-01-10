package mls.server_property.repositories;

import mls.server_property.domain.Freehold;
import mls.server_property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepo<T extends Property> extends JpaRepository<T, Long> {
//    @Query("select p from #{#entityName} p where type(p) = :type and p.address = :addr")
//    Optional<T> findByAddress(@Param("addr") String address, @Param("type") String d_type);

    Optional<T> findByAddress(String address);
    Optional<List<T>> findByAddressContainsAndPriceBetween(String partialAddress, int lowerBound, int upperBound);
    Optional<List<T>> findByPriceBetween(int lowerBound, int upperBound);
    Optional<List<T>> findByAddressContains(String partialAddress);

//    //need validation: T extends Freehold
//    @Query("select f from #{#entityName} f where f.type = ?1")
//    Optional<List<T>> findFreeholdByFamilyType(String type);
//    Optional<List<T>> findFreeholdByIsMultigeneration(boolean isMultigeneration);


}
