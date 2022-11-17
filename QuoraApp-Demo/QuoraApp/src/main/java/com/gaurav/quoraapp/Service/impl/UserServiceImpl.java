package com.gaurav.quoraapp.Service.impl;
import com.gaurav.quoraapp.Dto.UserDto;
import com.gaurav.quoraapp.Dto.request.RegisterUserRequestDTO;
import com.gaurav.quoraapp.Repo.ExpertiseRepo;
import com.gaurav.quoraapp.Repo.QuestionAnswerRepo;
import com.gaurav.quoraapp.Repo.RoleRepo;
import com.gaurav.quoraapp.Repo.UsersRepo;
import com.gaurav.quoraapp.Service.UserService;
import com.gaurav.quoraapp.model.Expertise;
import com.gaurav.quoraapp.model.QuestionAndAnswer;
import com.gaurav.quoraapp.model.Roles;
import com.gaurav.quoraapp.model.Users;
import org.apache.poi.ss.usermodel.*;

import com.gaurav.quoraapp.utils.AES;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    AES aes;

    @Value("${files.path}")
    private String filesPath;

    @Override
    public Users updateUpdateUser(Users users, Long id) {
        Users existingUser=usersRepo.findById(id).orElseThrow();
        existingUser.setName(users.getName());
        existingUser.setEmail(aes.encryptText("AES",users.getEmail()));
        existingUser.setDob(users.getDob());
        existingUser.setPhoneNumber(users.getPhoneNumber());
        existingUser.setABoolean(users.getABoolean());
        usersRepo.save(existingUser);
        return existingUser;
    }

    private List<UserDto> setterForUserDto(List<Users> users){
        List<UserDto> userDtoList = new ArrayList<>();
        for(Users users1: users){
            UserDto userDto=new UserDto();
            userDto.setId(users1.getUid());
            userDto.setDob(users1.getDob());
            userDto.setEmail(aes.decryptText("AES",users1.getEmail()));
            userDto.setGetABoolean(users1.getABoolean());
            userDto.setMobileNumber(users1.getPhoneNumber());
            userDto.setName(users1.getName());
            userDtoList.add(userDto);
        }
       return userDtoList;
    }

    @Override
    public List< UserDto > getAllUser() {
        //  System.out.println(usersRepo.findAll()+"blalalalalalalalala");
        //  return usersRepo.fetchAllUsers();

        return this.setterForUserDto(usersRepo.findAll());

    }

    @Override
    public Users getUserById(Long id) {

         return usersRepo.findById(id).orElseThrow();
    }

    public Resource download(String filename) {
        try {
            Path file = Paths.get(filesPath)
                    .resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    }


