package com.gaurav.loginapp.controller;

import com.gaurav.loginapp.Dto.UserDto;
import com.gaurav.loginapp.Entity.Users;
import com.gaurav.loginapp.constant.PathConstant;
import com.gaurav.loginapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(PathConstant.User)
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody
                                           Users users){
        System.out.println(users);
        return new ResponseEntity<Users>(userService.saveUser(users), HttpStatus.OK);

    }
    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsersByEmail();
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getByUserId(@PathVariable("id") int id){
           return new ResponseEntity<Users>(userService.getById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> updateEmployee(@PathVariable("id") int id, @RequestBody Users employee){
        return new ResponseEntity<Users>(userService.updateUser(employee, id),HttpStatus.OK);
    }




}
