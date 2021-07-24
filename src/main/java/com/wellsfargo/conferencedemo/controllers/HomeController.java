package com.wellsfargo.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${environment.value}")
    private String envType;

    @GetMapping("/")
    public Map getStatus(){
        Map<String,String> mapResult = new HashMap<>();
        mapResult.put("environment",envType);
        return mapResult;
    }

}
