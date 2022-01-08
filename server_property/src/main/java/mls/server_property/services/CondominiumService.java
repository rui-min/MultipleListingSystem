package mls.server_property.services;

import mls.server_property.repositories.CondominiumRepo;
import mls.server_property.repositories.ResidentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("condominiumServ")
public abstract class CondominiumService extends ResidentialService{
    private CondominiumRepo condominiumRepo;

    @Autowired
    public CondominiumService(@Qualifier("condominiumRepo") ResidentialRepo residentialRepo) {
        super(residentialRepo);
        this.condominiumRepo = (CondominiumRepo) residentialRepo;
    }
}
