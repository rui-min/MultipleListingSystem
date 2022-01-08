package mls.server_property.services;
import mls.server_property.repositories.ResidentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ResidentialService{

    // Use class specific xxxRepo for additional method implementations
    private final ResidentialRepo residentialRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired
    public ResidentialService( ResidentialRepo propertyRepo) {
        this.residentialRepo =  propertyRepo;
    }

    // Other basic crud methods are inherited from ABS PropertyService class

}
