package mls.server_property.repositories;
import mls.server_property.domain.Freehold;
import mls.server_property.domain.Property;
import mls.server_property.domain.Residential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface ResidentialRepo<T extends Residential> extends PropertyRepo<T> {
    Optional<List<T>> findBynOfParkingSpace(int nOfParkingSpace);
    Optional<List<T>> findByStorageType(String storageType);
    Optional<List<T>> findBynOfStorages(int nOfStorages);
    Optional<List<T>> findByBuiltDate(Date builtDate);
    Optional<List<T>> findByEntryDate(Date entryDate);
}
