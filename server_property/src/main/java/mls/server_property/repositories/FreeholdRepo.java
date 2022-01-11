package mls.server_property.repositories;

import mls.server_property.domain.Freehold;
import mls.server_property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FreeholdRepo<T extends Freehold> extends PropertyRepo<T> {
    Optional<List<T>> findByType(String type);
    Optional<List<T>> findByIsMultigenerationTrue();
    Optional<List<T>> findByIsMultigenerationFalse();
    Optional<List<T>> findByNumberOfFloors(int numberOfFloors);
    Optional<List<T>> findByNumberOfFloorsAndIsMultigenerationTrue(int numberOfFloors);
    Optional<List<T>> findByNumberOfFloorsAndIsMultigenerationFalse(int numberOfFloors);
    Optional<List<T>> findByTypeAndIsMultigenerationFalse(String type);
    Optional<List<T>> findByTypeAndIsMultigenerationTrue(String type);
    Optional<List<T>> findByNumberOfFloorsAndTypeAndIsMultigenerationTrue(int numberOfFloors, String type);
    Optional<List<T>> findByNumberOfFloorsAndTypeAndIsMultigenerationFalse(int numberOfFloors, String type);
}
