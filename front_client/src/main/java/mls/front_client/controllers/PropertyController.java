package mls.front_client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private String getPropertyTypeUri() {
        ServiceInstance instance = loadBalancerClient.choose("server_property");
        return instance.getUri().toString() + "/api/property/";
    }

}
