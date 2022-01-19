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
    @GetMapping("/get")
    public List<Property> index() {
        return propService.getAllProperties();
    }

    @GetMapping("/get/id/{id}")
    public Property getPropertyById(@PathVariable("id") Long id) throws IllegalStateException {
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
    @GetMapping("/get/type/{type}")
    public Optional<? extends List<? extends Property>> getTypeProperties(
                                            @PathVariable("type") String type,
                                            @RequestParam(required = false) String address,
                                            @RequestParam(required = false) Integer minPrice,
                                            @RequestParam(required = false) Integer maxPrice){
        if (address==null) address="";
        if (minPrice==null) minPrice=0;
        if (maxPrice==null) maxPrice=Integer.MAX_VALUE;
        return propService.getTypeProperties(type,address,minPrice,maxPrice);
    }

    @GetMapping("/get/minPrice/{minPrice}")
    public Optional<List<Property>> getMinPriceProperties(@PathVariable("minPrice") Integer minPrice) {
        return propService.getMinPriceProperties(minPrice);
    }

    @GetMapping("/get/maxPrice/{maxPrice}")
    public Optional<List<Property>> getMaxPriceProperties(@PathVariable("maxPrice") Integer maxPrice) {
        return propService.getMaxPriceProperties(maxPrice);
    }

    @GetMapping("/get/address/{address}")
    public Optional<List<Property>> getAddressProperties(
                                        @PathVariable("address") String address) {
        return propService.getAddressProperties(address);
    }


    @PostMapping("/post")
    public Property registerNewRecord(@RequestBody Property property) {
        return propService.addNewProperty(property);
    }

    @PutMapping("/put/id/{id}")
    public Property updateRecord(@PathVariable("id") Long id,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) Integer price) throws IllegalStateException {
        return propService.updateIdProperty(id, address, price);
    }

    // address exact match
    @PutMapping("/put/address/{address}")
    public Property updateRecord(@PathVariable("address") String address,
                             @RequestParam(required = false) Integer price) throws IllegalStateException {
        return propService.updateAddressProperty(address, price);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteRecord(@PathVariable("id") Long id) {
        propService.removeIdProperty(id);
        return "id: "+id+" deleted";
    }

    // address fuzzy match
    @DeleteMapping("/delete/address/{address}")
    public String deleteRecord(@PathVariable("address") String address) {
        Long num = propService.removeAddressProperty(address);
        return num+ " records with address containing: \""+address+"\" are deleted";
    }

}
