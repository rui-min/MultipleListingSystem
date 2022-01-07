package mls.server_property.services;

import mls.server_property.domain.Condo;
import mls.server_property.repositories.CondoRepo;
import mls.server_property.repositories.LandRepo;
import mls.server_property.repositories.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CondoService extends CondominiumService{
    private final CondoRepo condoRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired
    public CondoService(@Qualifier("CondoRepo") PropertyRepo propertyRepo) {
        super(propertyRepo);
        this.CondoRepo = (CondoRepo) propertyRepo;
    }
}
