package mls.server_property.services;

import mls.server_property.repositories.LandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("landServ")
public class LandService {

    // Use class specific xxxRepo for additional method implementations

    private final LandRepo landRepo;
    @Autowired
    public LandService(LandRepo landRepo) {
        this.landRepo = landRepo;
    }


    // Other basic crud methods are inherited from ABS PropertyService class
}
