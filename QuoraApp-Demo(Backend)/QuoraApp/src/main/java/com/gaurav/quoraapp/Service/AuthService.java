package com.gaurav.quoraapp.Service;

import com.gaurav.quoraapp.Dto.request.LoginUserRequestDTO;
import com.gaurav.quoraapp.Dto.request.RegisterUserRequestDTO;
import com.gaurav.quoraapp.Dto.response.LoginUserResponseDTO;
import com.gaurav.quoraapp.Dto.response.RegisterUserResponseDTO;
import com.gaurav.quoraapp.model.Users;

public interface AuthService {
    RegisterUserResponseDTO register(RegisterUserRequestDTO users);
    LoginUserResponseDTO login(LoginUserRequestDTO loginUserRequestDTO);
}
