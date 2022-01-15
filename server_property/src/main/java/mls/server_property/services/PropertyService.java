package mls.server_property.services;

import mls.server_property.domain.*;
import mls.server_property.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    // Avoid reporting no bean error for pRepo
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired private PropertyRepo<Property> propRepo;

    @Autowired private FreeholdRepo<Freehold> freeholdRepo;
    @Autowired private ResidentialRepo<Residential> residentialRepo;
    @Autowired private VacationHomeRepo vacationHomeRepo;
    @Autowired private LandRepo landPropertyRepo;
//    @Autowired

    public List<Property> getAllProperties(){ return propRepo.findAll(); }

    public Property getProperties(Long id) throws Throwable {
        return propRepo.findById(id).orElseThrow(() -> new IllegalStateException(
            String.format("No property with id %d exists", id))); }

    public List<Property> getProperties(List<Long> ids){
        return propRepo.findAllById(ids);
    }

    public void addNewProperty(Property property){
        Optional<Property> propOpt = propRepo.findByAddress(property.getAddress());
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
    public void updateProperty(Long id, String address, int price) throws Throwable {
        Property property = (Property) propRepo.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("No property with id %d exists", id)));
        if(property.getPrice() != price)
            property.setPrice(price);
        if(! property.getAddress().equals(address))
            property.setAddress(address);
    }
}
