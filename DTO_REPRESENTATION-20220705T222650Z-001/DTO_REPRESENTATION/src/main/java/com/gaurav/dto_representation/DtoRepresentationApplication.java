package com.gaurav.dto_representation;

import com.gaurav.dto_representation.model.UserEntity;
import com.gaurav.dto_representation.model.UserLocation;
import com.gaurav.dto_representation.repo.UserLocationRepo;
import com.gaurav.dto_representation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DtoRepresentationApplication implements CommandLineRunner {


    public static void main(String[] args) {

        SpringApplication.run(DtoRepresentationApplication.class, args);
    }
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserLocationRepo locationRepo;

    @Override
    public void run(String ... args ) throws Exception
    {
        UserLocation location=new UserLocation();
        location.setDescription("Kathmandu is awesome");
        location.setPlace("Kathmandu");
        location.setLatitude(30.4);
        location.setLongitude(40.5);
        locationRepo.save(location);

        UserEntity user1=new UserEntity();
        user1.setFname("Gaurav");
        user1.setLname("Basyal");
        user1.setPassword("jokjo");
       // user1.setUserLocation(location);
        user1.setEmail("hello@mail.com");
        userRepo.save(user1);

        UserEntity user2=new UserEntity();
        user2.setFname("Saurav");
        user2.setLname("Basyal");
        user2.setPassword("jokjo");
        //user2.setUserLocation(location);
        user2.setEmail("hi@mail.com");
        userRepo.save(user2);
    }
}
