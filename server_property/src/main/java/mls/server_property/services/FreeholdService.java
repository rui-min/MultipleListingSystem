package mls.server_property.services;

import mls.server_property.domain.Freehold;
import mls.server_property.repositories.FreeholdRepo;
import mls.server_property.repositories.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FreeholdService {
    @Autowired
    private  FreeholdRepo freeHoldRepo;

    public List<Freehold> findAllFreeholds() {
       return freeHoldRepo.findAll();
    }
    public 



}
