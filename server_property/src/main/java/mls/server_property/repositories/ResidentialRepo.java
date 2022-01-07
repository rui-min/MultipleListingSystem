package mls.server_property.repositories;


import mls.server_property.domain.Residential;
import org.springframework.data.repository.NoRepositoryBean;

import java.sql.Date;
import java.util.Optional;

@NoRepositoryBean
public interface ResidentialRepo extends PropertyRepo{
    // Duplicate queries
    Optional<Residential> findResidentialByNOfParkingSpace(int nOfParkingSpace);
    Optional<Residential> findResidentialByStorageType(String storageType);
    Optional<Residential> findResidentialByNOfStorages(int nOfStorages);
    Optional<Residential> findResidentialByBuiltDate(Date builtDate);
    Optional<Residential> findResidentialByEntryDate(Date entryDate);
}
