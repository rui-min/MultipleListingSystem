package mls.server_property.repositories;
import mls.server_property.domain.Property;
import mls.server_property.domain.Residential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface ResidentialRepo extends JpaRepository<Residential, Long> {
//    Optional<List<Residential>> findResidentialBynOfParkingSpace(int nOfParkingSpace);
//    Optional<List<Residential>> findResidentialBystorageType(String storageType);
//    Optional<List<Residential>> findResidentialBynOfStorages(int nOfStorages);
//    Optional<List<Residential>> findResidentialByBuiltDate(Date builtDate);
//    Optional<List<Residential>> findResidentialByEntryDate(Date entryDate);
}
