package com.source.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/htpt")
public class DemoController {

    @GetMapping("/getDemo")
    public Map<String, Boolean> getValues() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("Succeed", Boolean.TRUE);
        return response;
    }
}
