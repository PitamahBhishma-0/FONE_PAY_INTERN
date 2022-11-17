package com.gaurav.microservices.springcloud1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeText {
    @Value("${welcome.message}")
    String welcomeText;

    @RequestMapping("/")
    public String hello (){
        return welcomeText;
    }
}
