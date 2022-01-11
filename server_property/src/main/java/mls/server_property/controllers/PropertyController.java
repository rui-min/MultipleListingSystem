package mls.server_property.controllers;

import mls.server_property.domain.Property;
import mls.server_property.services.PropertyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/property")
public class PropertyController<T extends Property> {
    // All sub controller can extend this controller for basic crud service calls

    private PropertyService<T> propService;

    public PropertyController(@Qualifier("propServ") PropertyService propService){ this.propService = propService;}

    @GetMapping
    public List<T> index() {
        return propService.getProperties();
    }

    @GetMapping("{id}")
    public Property getPropertyById(@PathVariable("id") Long id) {
        return propService.getProperties(id);
    }

    @GetMapping()
    public List<T> getPropertiesById(@RequestParam List<Long> ids){
        return propService.getProperties(ids);
    }

    @DeleteMapping("{id}")
    public void deleteRecord(@PathVariable("id") Long id) {
        propService.removeProperty(id);
    }

    @PutMapping("{id}")
    public void updateRecord(@PathVariable("id") Long id,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) int price) {
        propService.updateProperty(id, address, price);
    }

    @PostMapping("/post-record")
    public void registerNewRecord(@RequestBody T property) {
        propService.addNewProperty(property);
    }
}
