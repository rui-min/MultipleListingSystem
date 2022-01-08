package mls.front_client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

public class PropertyController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;


}
