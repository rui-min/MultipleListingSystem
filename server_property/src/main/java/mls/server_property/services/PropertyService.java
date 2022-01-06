package mls.server_property.services;

import mls.server_property.domain.Property;
import mls.server_property.repositories.PropertyRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class PropertyService {

    // Not final, every child service can access and have one propRepo for aliasing
    private PropertyRepo propRepo;

    // ABS can't @Autowire construct
    public PropertyService(PropertyRepo propRepo) {
        this.propRepo = propRepo;
    }

    // Non-abstract, inheritable general crud methods
    public List<Property> getProperties(){ return propRepo.findAll(); }

    public void addNewProperty(Property property){
        Optional<Property> propOpt = propRepo.findPropertyByAddress(property.getAddress());
        if(propOpt.isPresent()){
            throw new IllegalStateException("Property exists at this address");
        }
        propRepo.save(property);
    }

    public void removeProperty(Long id){
        if(! propRepo.existsById(id)){
            throw new IllegalStateException(String.format("No property with id %d exists", id));
        }
        propRepo.deleteById(id);
    }

    @Transactional
    public void updatePropertyPrice(Long id, int price){
        Property property = propRepo.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("No property with id %d exists", id)));
        if(property.getPrice() != price)
            property.setPrice(price);
    }
}
