package com.example.springbootlearn.api;

import com.example.springbootlearn.service.BusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleApi {
    private final BusinessService businessService;

    public SampleApi(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping(value = "/hello")
    public String getData() {
        return businessService.getBusiness();
    }

    @GetMapping(value = "/hello2")
    public String getData2() {
        return businessService.getBusiness2();
    }

    @GetMapping(value = "/retry")
    public String getRetry(@RequestParam Boolean first, @RequestParam Boolean two) {
        return businessService.getBusinessRetry(first, two);
    }
}
