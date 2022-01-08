package mls.server_property.services;

import mls.server_property.domain.Freehold;
import mls.server_property.repositories.FreeholdRepo;

import java.util.List;

public abstract class FreeholdService extends PropertyService {
    private FreeholdRepo freeHoldRepo;

    public FreeholdService(FreeholdRepo repo) {
        super(repo);
        this.freeHoldRepo = repo;
    }

    public List<Freehold> findFreeholds() {
       return freeHoldRepo.findAll();
    }


}
