package mls.server_property.controllers;

import mls.server_property.domain.Land;
import mls.server_property.domain.Property;
import mls.server_property.services.LandService;
import mls.server_property.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/property/land") // Put url prefix as concrete class inheritance form
public class LandController extends PropertyController {

    private final LandService landService;

    @Autowired
    public LandController(@Qualifier("landServ") PropertyService propService){
        super(propService);
        landService = (LandService) propService;
    }

    @Override
    @GetMapping("/")
    public List<Property> getPropertiesById(@RequestParam List<Long> ids){
        return landService.getProperties(ids);
    }
}
