package mls.front_client.controllers;

import mls.front_client.dto.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertyController {

//    @GetMapping("hello")
//    public String index(Model model){
//        return "result";
//    }

    @GetMapping("post")
    public String postNewProp(){

        return "postNewProp";
    }
}
