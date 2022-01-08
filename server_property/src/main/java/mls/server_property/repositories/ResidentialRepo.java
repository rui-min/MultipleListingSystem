package mls.server_property.repositories;
import mls.server_property.domain.Residential;
import org.springframework.data.repository.NoRepositoryBean;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ResidentialRepo<T extends Residential> extends PropertyRepo<Residential>{
    Optional<List<T>> findResidentialByNOfParkingSpace(int nOfParkingSpace);
    Optional<List<T>> findResidentialByStorageType(String storageType);
    Optional<List<T>> findResidentialByNOfStorages(int nOfStorages);
    Optional<List<T>> findResidentialByBuiltDate(Date builtDate);
    Optional<List<T>> findResidentialByEntryDate(Date entryDate);
}
