package mls.server_property.services;

import mls.server_property.repositories.CondoRepo;
import mls.server_property.repositories.PropertyRepo;
import mls.server_property.repositories.ResidentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CondoService extends CondominiumService{
    private final CondoRepo condoRepo;
//todo
    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired
    public CondoService(@Qualifier("CondoRepo") ResidentialRepo residentialRepo, CondoRepo condoRepo) {
        super(residentialRepo);
        this.condoRepo = condoRepo;
    }
}
