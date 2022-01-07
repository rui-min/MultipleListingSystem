package mls.server_property.repositories;

import mls.server_property.domain.Property;
import org.springframework.data.repository.NoRepositoryBean;

import java.sql.Date;
import java.util.Optional;

@NoRepositoryBean
public interface ResidentialRepo extends PropertyRepo{
    // Duplicate queries
    Optional<Property> findResidentialByNOfParkingSpace(int nOfParkingSpace);
    Optional<Property> findResidentialByStorageType(String storageType);
    Optional<Property> findResidentialByNOfStorages(int nOfStorages);
    Optional<Property> findResidentialByBuiltDate(Date builtDate);
    Optional<Property> findResidentialByEntryDate(Date entryDate);
}
