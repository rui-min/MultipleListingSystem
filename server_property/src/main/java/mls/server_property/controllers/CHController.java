package mls.server_property.controllers;

import mls.server_property.domain.CooperativeHome;
import mls.server_property.domain.Property;
import mls.server_property.repositories.CooperativeHomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/vh")
public class CHController {
    @Autowired
    private CooperativeHomeRepo chRepo;

    @GetMapping("/")
    public Iterable<Property> index() {
        return chRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Property> getPropertyById(@PathVariable long id) {
        return chRepo.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        chRepo.deleteById(id);
    }

    @PutMapping("/update-record")
    public void updateProduct(@RequestBody CooperativeHome product) {
        chRepo.save(product);
    }

    @PostMapping("/post-record")
    public void postProduct(@RequestBody CooperativeHome product) {
        chRepo.save(product);
    }

}
