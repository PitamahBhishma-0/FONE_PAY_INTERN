package com.gaurav.microservices.springcloud1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@EnableConfigServer
@SpringBootApplication
public class SpringCloud1Application {


    public static void main(String[] args) {
        SpringApplication.run(SpringCloud1Application.class, args);
    }



}
