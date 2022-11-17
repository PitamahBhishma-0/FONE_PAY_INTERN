package com.gaurav.loginapp.service;

import com.gaurav.loginapp.Dto.UserDto;
import com.gaurav.loginapp.Entity.Users;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUsersByEmail();
    public Users saveUser(Users users);
    public Users getById(int id);
    public void deleteById(int id);

    public Users updateUser(Users users, int id);

}
