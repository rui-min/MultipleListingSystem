package mls.server_property.repositories;

import mls.server_property.domain.Freehold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FreeholdRepo extends JpaRepository<Freehold, Long> {
//    Optional<List<Freehold>> findFreeholdByType(String type);
//    Optional<List<Freehold>> findFreeholdByIsMultigeneration(boolean isMultigeneration);
//    Optional<List<Freehold>> findFreeholdByNumberOfFloors(int numberOfFloors);
}
