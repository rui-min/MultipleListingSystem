package mls.server_property.controllers;

import mls.server_property.domain.CooperativeHome;
import mls.server_property.domain.Property;
import mls.server_property.repositories.CooperativeHomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/ch")
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

    @PutMapping("/update")
    public void updateProduct(@RequestBody CooperativeHome ch) {
        chRepo.save(ch);
    }

    @PostMapping("/add")
    public void postProduct(@RequestBody CooperativeHome ch) {
        chRepo.save(ch);
    }

}
