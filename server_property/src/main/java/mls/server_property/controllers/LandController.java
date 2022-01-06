package mls.server_property.controllers;

import mls.server_property.domain.CooperativeHome;
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

//    public LandController(LandService landService) {
//        this.landService = landService;
//    }

    @GetMapping("/")
    public Iterable<Property> index() {
        return landService.getLandRepo().findAll();
    }

    @GetMapping("/{id}")
    public Optional<Property> getPropertyById(@PathVariable long id) {
        return landService.getLandRepo().findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        landService.getLandRepo().deleteById(id);
    }

    @PutMapping("/update-record")
    public void updateProduct(@RequestBody CooperativeHome product) {
        landService.getLandRepo().save(product);
    }

    @PostMapping("/post-record")
    public void postProduct(@RequestBody CooperativeHome product) {
        landService.getLandRepo().save(product);
    }

}
