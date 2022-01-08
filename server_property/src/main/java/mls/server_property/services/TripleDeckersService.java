package mls.server_property.services;

import mls.server_property.repositories.ResidentialRepo;
import mls.server_property.repositories.TripleDeckersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TripleDeckersService extends CondominiumService{
    private final TripleDeckersRepo tripleDeckersRepo;

    // Constructor injection & Alias cast
    // In case of multiple inheritance,specify Qualifier("xxxRepo") the same as @Repository("xxxRepo")
    @Autowired
    public TripleDeckersService(@Qualifier("TripleDeckersRepo") ResidentialRepo residentialRepo, TripleDeckersRepo tripleDeckersRepo) {
        super(residentialRepo);
        this.tripleDeckersRepo = tripleDeckersRepo;
    }
}
