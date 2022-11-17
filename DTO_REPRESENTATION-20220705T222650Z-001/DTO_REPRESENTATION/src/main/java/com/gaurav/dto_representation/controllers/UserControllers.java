package com.gaurav.dto_representation.controllers;

import com.gaurav.dto_representation.UserDto.UserDto;
import com.gaurav.dto_representation.constant.PathConstant;
import com.gaurav.dto_representation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController("/user")
public class UserControllers {
    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public List<UserDto> getAllUser()
    {

        return userService.getAllUserLocation();
    }

}
