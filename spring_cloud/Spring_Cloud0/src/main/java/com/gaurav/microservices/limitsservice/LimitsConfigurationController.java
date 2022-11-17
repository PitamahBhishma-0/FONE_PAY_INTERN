package com.gaurav.microservices.limitsservice;

import com.gaurav.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    Configuration configuration;
    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
