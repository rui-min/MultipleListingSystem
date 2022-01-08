package mls.server_property.services;

import mls.server_property.repositories.ResidentialRepo;
import mls.server_property.repositories.StackedTownHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StackedTownHouseService extends CondominiumService{

    private final StackedTownHouseRepo stackedTownHouseRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired
    public StackedTownHouseService(@Qualifier("StackedTownHouseRepo") ResidentialRepo residentialRepo, StackedTownHouseRepo stackedTownHouseRepo) {
        super(residentialRepo);
        this.stackedTownHouseRepo = stackedTownHouseRepo;
    }
}
