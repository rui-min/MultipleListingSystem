package mls.front_client.controllers;

import mls.front_client.dto.FormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Optional;

@Controller
public class PropertyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private String getProductBaseUri() {
        ServiceInstance instance = loadBalancerClient.choose("localhost: 8090/server");
        return instance.getUri().toString() + "/api/product/";
    }



    private String getPropertyTypeUri() {
        ServiceInstance instance = loadBalancerClient.choose("server_property");
        return instance.getUri().toString() + "/api/property/";
    }

    @GetMapping(value="/index")
    public String getProperties(@RequestBody FormDTO formGet, Model model){
        // e.g.https://...//api/property/Land
        String url=getPropertyTypeUri()+formGet.getPropertyType();
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();

        ParameterizedTypeReference<Optional<FormDTO>> responseType =
                new ParameterizedTypeReference<Optional<FormDTO>>() {};

        Optional<FormDTO> formReturn = restTemplate.exchange(request, responseType).getBody();

        if (formReturn.isEmpty()) {
            model.addAttribute("error","No such type properties");
        }
        else {

        }

        return "result";
    }


//    @ModelAttribute("allTypes")
//    public String[] allPropertyTypes () {
//        return new String[] { "Land", "CooperativeHome", "MobileHome", "SemiDetached",
//                "VacationHome","DetachedHome","FarmHouse","MultiLex","TownHouse",
//                "TripleDeckers","Condo","StackedTownHouse"};
//    }
}
