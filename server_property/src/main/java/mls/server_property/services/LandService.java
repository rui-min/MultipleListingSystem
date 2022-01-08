package mls.server_property.services;

import mls.server_property.repositories.LandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("landServ")
public class LandService extends  PropertyService{

    // Use class specific xxxRepo for additional method implementations
    private final LandRepo landRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired

    public LandService(@Qualifier("landRepo") PropertyRepo propertyRepo) {
        super(propertyRepo);
        this.landRepo = (LandRepo) propertyRepo;
    }


    // Other basic crud methods are inherited from ABS PropertyService class
}
