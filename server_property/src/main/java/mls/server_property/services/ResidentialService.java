package mls.server_property.services;
import mls.server_property.repositories.ResidentialRepo;
import org.springframework.stereotype.Service;

@Service
public abstract class ResidentialService extends PropertyService{

    // Use class specific xxxRepo for additional method implementations
    private ResidentialRepo residentialRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    public ResidentialService( ResidentialRepo propertyRepo) {
        super(propertyRepo);
        this.residentialRepo =  propertyRepo;
    }

    // Other basic crud methods are inherited from ABS PropertyService class

}
