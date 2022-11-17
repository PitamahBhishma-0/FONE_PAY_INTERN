package com.gaurav.quoraapp.controller;

import com.gaurav.quoraapp.Dto.request.LoginUserRequestDTO;
import com.gaurav.quoraapp.Dto.request.RegisterUserRequestDTO;
import com.gaurav.quoraapp.Dto.response.LoginUserResponseDTO;
import com.gaurav.quoraapp.Dto.response.RegisterUserResponseDTO;
import com.gaurav.quoraapp.utils.PathConstant;
import com.gaurav.quoraapp.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping(PathConstant.REGISTER_USER)
    public RegisterUserResponseDTO register(@Valid  @RequestBody RegisterUserRequestDTO users){
        return authService.register(users);
    }

    @PostMapping(PathConstant.LOGIN_USER)
    public LoginUserResponseDTO login(@RequestBody LoginUserRequestDTO loginUserRequestDTO){
        System.out.println("DEBUGGGGGGERER"+loginUserRequestDTO);
        return authService.login(loginUserRequestDTO);
    }

}
