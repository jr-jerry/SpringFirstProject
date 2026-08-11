package com.Ducat.SpringFirstProject.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//When we apply restController annotation on any class ,it method return a json response ! 
public class TestController{
    //tomcat server -->http://localhost:8080+get-->,http://localhost:8080/get 
    @GetMapping("/get")
    public String getEndpoint(){
        return "spring boot project working ";
    }

    @GetMapping("/get/map")
    public Map<String,String> getEndpoint2(){
        return Map.of("data","demo-data ");
    }
}
