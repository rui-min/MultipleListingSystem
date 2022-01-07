package mls.server_property.controllers;

import mls.server_property.domain.Land;
import mls.server_property.domain.Property;
import mls.server_property.services.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/land")
public class LandController {
    @Autowired
    private LandService landService;    // final cannot be "Autowired"

    @GetMapping("/")
    public Iterable<Property> index() {
        return landService.getLandRepo().findAll();
    }

    @GetMapping("/{id}")
    public Optional<Property> getPropertyById(@PathVariable long id) {
        return landService.getLandRepo().findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable long id) {
        landService.getLandRepo().deleteById(id);
    }

    // TODO: should be "Land" type or "Property" type??
    @PutMapping("/update-record")
    public void updateRecord(@RequestBody Land land) {
        landService.getLandRepo().save(land);
    }

    @PostMapping("/post-record")
    public void postRecord(@RequestBody Land land) {
        landService.getLandRepo().save(land);
    }

}
