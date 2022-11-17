package com.gaurav.loginapp.service.impl;

import com.gaurav.loginapp.Dto.UserDto;
import com.gaurav.loginapp.Entity.Users;
import com.gaurav.loginapp.repo.RoleRepo;
import com.gaurav.loginapp.repo.UserRepo;
import com.gaurav.loginapp.service.UserService;
import com.gaurav.loginapp.utils.AesConverter;
import com.gaurav.loginapp.utils.RsaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    AesConverter aesConverter;
    @Autowired
    RsaConverter rsaConverter;




    SecretKey secretKey;

    public UserDto convertEntityToDto(Users users){
        UserDto userDto = new UserDto();
        userDto.setEmail(users.getEmail());
        try{
            userDto.setPassword(aesConverter.encrypt(users.getPassword(), "secretKey"));

        }
        catch (Exception e){

        }
        return userDto;
    }


    @Override
    public List<UserDto> getAllUsersByEmail() {
        return userRepo.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Users saveUser(Users users)
    {
        //users.setPassword(aesConverter.encrypt(users.getPassword(),"secretKey"));
        try {
            users.setPassword(rsaConverter.encrypt(users.getPassword()));
        }
        catch (Exception e){

        }
        return userRepo.save(users);

    }

    @Override
    public Users getById(int id) {
        return  userRepo.findById(id).get();

    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Users updateUser(Users users, int id) {
        Users existingUser =userRepo.findById(id).orElseThrow();
        existingUser.setfName(users.getfName());
        existingUser.setlName(users.getlName());
        existingUser.setEmail(users.getEmail());
        existingUser.setPassword(users.getPassword());
        existingUser.setAddress(users.getAddress());
        userRepo.save(existingUser);
        return existingUser;

    }
}
