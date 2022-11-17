package com.gaurav.dto_representation.service;

import com.gaurav.dto_representation.UserDto.UserDto;
import com.gaurav.dto_representation.model.UserEntity;
import com.gaurav.dto_representation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService {

    @Autowired
    private  UserRepo userRepo;

//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }


    public List<UserDto> getAllUserLocation(){
        return userRepo.findAll().stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private UserDto convertEntityToDto(UserEntity userEntity){
        UserDto userDto=new UserDto();
        userDto.setUserId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPlace(userEntity.getUserLocation().getPlace());
        userDto.setLongitude(userEntity.getUserLocation().getLongitude());
        userDto.setLatitude(userEntity.getUserLocation().getLatitude());
        return userDto;
    }

}
