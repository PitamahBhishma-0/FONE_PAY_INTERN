package com.gaurav.quoraapp.Service;

import com.gaurav.quoraapp.Dto.UserDto;
import com.gaurav.quoraapp.Dto.request.RegisterUserRequestDTO;
import com.gaurav.quoraapp.model.Roles;
import com.gaurav.quoraapp.model.Users;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface UserService {

    public Users updateUpdateUser(Users users,Long id);

    public List<UserDto> getAllUser();

    public Users getUserById(Long id);


    Resource download(String filename);
}