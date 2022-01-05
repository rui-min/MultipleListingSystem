package mls.server_property.controllers;

import mls.server_property.domain.Condo;
import mls.server_property.service.CondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/condominium")
public class CondoController {
    @Autowired
    private CondoService condoService;

    @GetMapping("/condo")
    public List<Condo> fetchAllCondo() {
        return condoService.findAll();
    }
    @GetMapping("/condo/{id}")
    public Condo getPropertyById(@PathVariable long id) {
        return condoService.findById(id);
    }
    @PostMapping("/condo")
    public Condo saveCondo( @RequestBody Condo condo){
        return condoService.saveCondo(condo);
    }
    @PutMapping("/condo/{id}")
    public String updateCondo(@PathVariable("id") long id,
                                         @RequestBody Condo condo){
        return condoService.updateCondo(id, condo);
    }
    @DeleteMapping("/condo/{id}")
    public String deleteGradeRecordById(@PathVariable("id") Long id){
        condoService.deleteCondoById(id);
        return "GradeRecord deleted Successfully!!";
    }

//    @PostMapping("api/condominium/")
//    public  saveCondo(@Validated @RequestBody Condo condo, @PathVariable String type){
//        return condoService.saveCondo(condo);
//    }
//    @PostMapping("api/condominium/condo")
//    public  saveCondo(@Validated @RequestBody Condo condo, @PathVariable String type){
//        return condoService.saveCondo(condo);
//    }
//    @GetMapping("api/condominium/{type}")
//    public List<? extends Condominium> getCondominiumList(@PathVariable String type){
//        return condominiumService.getAllCondomium(type);
//    }

}
