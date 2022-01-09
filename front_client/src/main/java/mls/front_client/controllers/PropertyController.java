package mls.front_client.controllers;

import mls.front_client.dto.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PropertyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private String getServerUri() {
        ServiceInstance instance = loadBalancerClient.choose("localhost: 8090");
        return instance.getUri().toString() + "/api/";
    }

    @PostMapping ("/index")
    public String searchRequest(@ModelAttribute PropertyDto dto) {
        String url = getServerUri() + dto.getType();
        if (dto.getId() != null) url += "/id/" + dto.getId();
        else if (dto.getAddress() != null) url += "/address/" + dto.getAddress();
//        else if ()

        return "result";
    }
//        RestTemplate restTemplate = new RestTemplate();
//        RequestEntity<Void> request = RequestEntity.get(url)
//                .accept(MediaType.APPLICATION_JSON).build();
////???
//        ParameterizedTypeReference<Optional<List<PropertyDto>>> responseType =
//                new ParameterizedTypeReference<Optional<List<PropertyDto>>>() {};
//
//        Optional<List<PropertyDto>> properties =  restTemplate.exchange(request, responseType).getBody();
//
//        return ResponseEntity.ok(properties.get());
    }




