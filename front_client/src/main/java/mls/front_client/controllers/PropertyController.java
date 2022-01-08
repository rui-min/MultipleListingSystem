package mls.front_client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

public class PropertyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private String getProductBaseUri() {
        ServiceInstance instance = loadBalancerClient.choose("localhost: 8090/");
        return instance.getUri().toString() + "/api/product/";
    }

}
