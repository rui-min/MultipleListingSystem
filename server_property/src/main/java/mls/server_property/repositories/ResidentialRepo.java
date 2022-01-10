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
    Optional<List<T>> findResidentialBynOfParkingSpace(int nOfParkingSpace);
    Optional<List<T>> findResidentialByStorageType(String storageType);
    Optional<List<T>> findResidentialBynOfStorages(int nOfStorages);
    Optional<List<T>> findResidentialByBuiltDate(Date builtDate);
    Optional<List<T>> findResidentialByEntryDate(Date entryDate);
}
