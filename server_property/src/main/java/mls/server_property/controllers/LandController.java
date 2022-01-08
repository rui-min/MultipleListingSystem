package mls.server_property.controllers;

import mls.server_property.services.LandService;
import mls.server_property.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/property/land") // Put url prefix as concrete class inheritance form
public class LandController {
    @Autowired
    private LandService landService;

}
