package mls.server_property.controllers;

import mls.server_property.domain.Residential;
import mls.server_property.domain.Property;
import mls.server_property.services.ResidentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/residential")
public class ResidentialController {
    @Autowired
    private ResidentialService residentialService;    // final cannot be "Autowired"

    @GetMapping("/")
    public Iterable<Property> index() {
        return residentialService.getResidentialRepo().findAll();
    }

    @GetMapping("/{id}")
    public Optional<Property> getPropertyById(@PathVariable long id) {
        return residentialService.getResidentialRepo().findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable long id) {
        residentialService.getResidentialRepo().deleteById(id);
    }

    // Property type can avoid "Inferred type 'S' for type parameter 'S' is not within its bound;
    // should extend 'mls.server_property.domain.Property'" error
    @PutMapping("/update-record")
    public void updateRecord(@RequestBody Property residential) {
        residentialService.getResidentialRepo().save(residential);
    }

    // Property type can avoid "Inferred type 'S' for type parameter 'S' is not within its bound;
    // should extend 'mls.server_property.domain.Property'" error
    @PostMapping("/post-record")
    public void postRecord(@RequestBody Property residential) {
        residentialService.getResidentialRepo().save(residential);
    }

}
