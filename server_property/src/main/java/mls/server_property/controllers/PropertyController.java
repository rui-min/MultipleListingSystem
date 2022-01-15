package mls.server_property.controllers;

import mls.server_property.domain.Property;
import mls.server_property.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/property")
public class PropertyController {

    private final PropertyService propService;
    @Autowired
    public PropertyController(@Qualifier("propServ") PropertyService propService){ this.propService = propService;}

    @GetMapping("/")
    public List<Property> index() {
        return propService.getAllProperties();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable("id") Long id) throws Throwable {
        return propService.getProperties(id);
    }

    /**
     * @param type must be one of: Property, Land, Residential, Freehold, CooperativeHome,
     *             Condominium, MobileHome, SemiDetached, VacationHome, DetachedHome,
     *             FarmHouse, MultiLex, TownHouse, TripleDeckers, Condo, StackedTownHouse
     * @param partialAddress optional param
     * @param minPrice optional param
     * @param maxPrice optional param
     * @return an Optional list of specified type's properties
     */
    @GetMapping("/{type}")
    public Optional<? extends List<? extends Property>> getTypeProperties(
                                            @PathVariable("type") String type,
                                            @RequestParam(required = false) String partialAddress,
                                            @RequestParam(required = false) int minPrice,
                                            @RequestParam(required = false) int maxPrice){
        return propService.getProperties(type,partialAddress,minPrice,maxPrice);
    }

//    @GetMapping("/")
//    public List<Property> getPropertiesById(@RequestParam List<Long> ids){
//        return propService.getProperties(ids);
//    }

    @PutMapping("{id}")
    public void updateRecord(@PathVariable("id") Long id,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) int price) throws Throwable {
        propService.updateProperty(id, address, price);
    }

    @PostMapping("/post-record")
    public void registerNewRecord(@RequestBody Property property) {
        propService.addNewProperty(property);
    }


    @DeleteMapping("{id}")
    public void deleteRecord(@PathVariable("id") Long id) {
        propService.removeProperty(id);
    }
}
