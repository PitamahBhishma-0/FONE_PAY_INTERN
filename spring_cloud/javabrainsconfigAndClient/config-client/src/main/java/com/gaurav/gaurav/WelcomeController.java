package com.gaurav.gaurav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeController {
    @Value("${my.greetings}")
    String hello;
    @Autowired
    private DbSettings dbSettings;
    @RequestMapping("/greetings")
    public String greetings(){
        return dbSettings.getConnection()+" host "+ dbSettings.getHost();
    }
}
