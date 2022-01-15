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

    // empty instead of "/" to facilitate both with and without "/" urls
    @GetMapping
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
     * @param address Partial Address for fuzzy string searching; optional param (better include)
     * @param minPrice optional param (better include)
     * @param maxPrice optional param (better include)
     * @return an Optional list of specified type's properties
     */
//    @GetMapping("/{type}")    <- will cause ambiguous handler methods error
    @GetMapping("/type")
    public Optional<? extends List<? extends Property>> getTypeProperties(
                                            @RequestParam("type") String type,
                                            @RequestParam(required = false) String address,
                                            @RequestParam(required = false) Integer minPrice,
                                            @RequestParam(required = false) Integer maxPrice){
        if (address==null) address="";
        if (minPrice==null) minPrice=0;
        if (maxPrice==null) maxPrice=Integer.MAX_VALUE;
        return propService.getProperties(type,address,minPrice,maxPrice);
    }

    @GetMapping("/ids")
    public List<Property> getPropertiesById(@RequestParam List<Long> ids){
        return propService.getProperties(ids);
    }

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
