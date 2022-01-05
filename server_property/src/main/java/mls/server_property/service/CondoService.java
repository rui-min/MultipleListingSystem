package mls.server_property.service;

import mls.server_property.domain.Condo;
import mls.server_property.repositories.CondoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CondoService {
    @Autowired
    private CondoRepo condoRepo;
    public Condo saveCondo(Condo condo){
        if(condoRepo.findByAddress(condo.getAddress()) == null)
            return condoRepo.save( new Condo("89DF", 899) );
        return null;
    }

    public List<Condo> findAll() {
        return condoRepo.findAll();
    }

    public Condo findById(long id) {
        return condoRepo.findById(id) .orElseThrow(() -> new IllegalStateException
                ("String.format(\"No Condo with id %d exists\", id)") );
    }
    public void deleteCondoById(Long id){
        if(! condoRepo.existsById(id)){
            throw new IllegalStateException(String.format("No Condo with id %d exists", id));
        }
        condoRepo.deleteById(id);
    }
    @Transactional
    public String updateCondo(Long id, Condo newcondo){
        Condo condo = condoRepo.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("No Condo with id %d exists", id)));
        if(condo.getPrice() != newcondo.getPrice())
            condo.setPrice(newcondo.getPrice());
        return "success!";
    }
}
