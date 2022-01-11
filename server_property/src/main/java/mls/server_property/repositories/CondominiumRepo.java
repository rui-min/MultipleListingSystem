package mls.server_property.repositories;

import mls.server_property.domain.Condominium;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CondominiumRepo<T extends Condominium> extends ResidentialRepo<T>{
    Optional<List<T>> findCondominiumNByOfParkingSpace(int nOfParkingSpace);
    Optional<List<T>> findCondominiumByStorageType(String storageType);
    Optional<List<T>> findCondominiumByNOfStorages(int nOfStorages);
    Optional<List<T>> findCondominiumByBuiltDate(Date builtDate);
    Optional<List<T>> findCondominiumByEntryDate(Date entryDate);

}
