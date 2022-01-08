package mls.server_property.repositories;

import mls.server_property.domain.Condominium;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@NoRepositoryBean
@Repository("condominiumRepo")
public interface CondominiumRepo extends ResidentialRepo{
    Optional<Condominium> findCondominiumNByOfParkingSpace(int nOfParkingSpace);
    Optional<Condominium> findCondominiumByStorageType(String storageType);
    Optional<Condominium> findCondominiumByNOfStorages(int nOfStorages);
    Optional<Condominium> findCondominiumByBuiltDate(Date builtDate);
    Optional<Condominium> findCondominiumByEntryDate(Date entryDate);

}
