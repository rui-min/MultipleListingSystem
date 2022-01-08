package mls.server_property.controllers;

import mls.server_property.services.ResidentialService;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/property/residential")
public abstract class ResidentialController extends PropertyController {

    private ResidentialService resiService;

    public ResidentialController(ResidentialService resiService) {
        super(resiService);
    }
}
