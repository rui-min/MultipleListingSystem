package mls.server_property.controllers;

import mls.server_property.domain.Condominium;
import mls.server_property.services.CondominiumService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CondominiumController extends ResidentialController{
    private CondominiumService condominiumService;

    public CondominiumController(CondominiumService condominiumService) {
        super(condominiumService);
    }
}
