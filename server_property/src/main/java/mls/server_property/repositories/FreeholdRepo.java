package mls.server_property.repositories;

import mls.server_property.domain.Freehold;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface FreeholdRepo<T extends Freehold> extends ResidentialRepo<Freehold>{
    Optional<List<T>> findFreeholdByType(String type);
    Optional<List<T>> findFreeholdByMultiGenerationType(boolean isMultigeneration);
    Optional<List<T>> findFreeholdByNumberOfFloors(int numberOfFloors);
}
