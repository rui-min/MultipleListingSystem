package mls.server_property.services;

import mls.server_property.repositories.PropertyRepo;
import mls.server_property.repositories.ResidentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public abstract class ResidentialService extends PropertyService{

    // Use class specific xxxRepo for additional method implementations
    private ResidentialRepo residentialRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired
    public ResidentialService(@Qualifier("landRepo") PropertyRepo propertyRepo) {
        super(propertyRepo);
        this.residentialRepo = (ResidentialRepo) propertyRepo;
    }

    // Other basic crud methods are inherited from ABS PropertyService class
    // Ex. use addNewProperty(Residential residential) for adding residential or sub concrete-obj
//    public ResidentialRepo getResidentialRepo() {
//        return residentialRepo;
//    }

}
