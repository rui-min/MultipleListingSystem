package mls.server_property.repositories;

import mls.server_property.domain.VacationHome;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("vacationHomeRepo")
public interface VacationHomeRepo extends FreeholdRepo<VacationHome> {

}