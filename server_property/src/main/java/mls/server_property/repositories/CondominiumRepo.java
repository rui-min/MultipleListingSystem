package mls.server_property.repositories;

import mls.server_property.domain.Condominium;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondominiumRepo<T extends Condominium> extends ResidentialRepo<T> {
    Optional<List<T>> findByUnitNumber(int unitNumber);

}
