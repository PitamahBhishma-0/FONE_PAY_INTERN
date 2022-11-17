package com.gaurav.quoraapp.Service.impl;

import com.gaurav.quoraapp.Dto.request.LoginUserRequestDTO;
import com.gaurav.quoraapp.Dto.request.RegisterUserRequestDTO;
import com.gaurav.quoraapp.Dto.response.LoginUserResponseDTO;
import com.gaurav.quoraapp.Dto.response.RegisterUserResponseDTO;
import com.gaurav.quoraapp.Dto.response.RoleResponse;
import com.gaurav.quoraapp.Repo.ExpertiseRepo;
import com.gaurav.quoraapp.Repo.RoleRepo;
import com.gaurav.quoraapp.Repo.UsersRepo;
import com.gaurav.quoraapp.Service.AuthService;
import com.gaurav.quoraapp.error.QuoraException;
import com.gaurav.quoraapp.model.Expertise;
import com.gaurav.quoraapp.model.Roles;
import com.gaurav.quoraapp.model.Users;
import com.gaurav.quoraapp.utils.AES;
import com.gaurav.quoraapp.utils.JwtUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AES aes;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomUserDetails userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    ExpertiseRepo expertiseRepo;

    @Autowired
    RoleRepo roleRepo;

    @Override
    public RegisterUserResponseDTO register(RegisterUserRequestDTO users) {
        try{
            // save user
            Users user = new Users();
            user.setDob(users.getDob());
            user.setEmail(aes.encryptText("AES",users.getEmail()));
            user.setABoolean(users.getABoolean());
            user.setName(users.getName());
            user.setPhoneNumber(users.getPhoneNumber());
            user.setPassword(passwordEncoder.encode(users.getPassword()));
            Users savedUser = usersRepo.save(user);

            // save also list of experties   of that user
            for(String exp : users.getExperties()){
                Expertise expertise = new Expertise();
                expertise.setExpertise(exp);
                expertise.setUsers(savedUser);
                expertiseRepo.save(expertise);
            }
            List<String> defaultRole=new ArrayList<>();
            defaultRole.add("USER");
            //set roles for that user  users.getRoles()
            for(String role: defaultRole){
                Roles roles =new Roles();
                roles.setRole(role);
                roles.setUsers(savedUser);
                roleRepo.save(roles);

            }

            //set dto
            RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
            registerUserResponseDTO.setName(user.getName());
            registerUserResponseDTO.setMessage("SUCCESS");
            return registerUserResponseDTO;
        } catch (Exception e){
            throw new QuoraException(e.getMessage());
        }
    }

    @Override
    public LoginUserResponseDTO login(LoginUserRequestDTO loginUserRequestDTO) {

        try{
            // get that user from given login request
            System.out.println(loginUserRequestDTO.getEmail());
            Users users = usersRepo.findUsersByEmail(aes.encryptText("AES",loginUserRequestDTO.getEmail()));
            if(users == null){
                throw new QuoraException("User doesnt exists");
            }

            // check if given password matches the database password
            String encodedPassword = usersRepo.findById(users.getUid()).get().getPassword();
            boolean result = passwordEncoder.matches(loginUserRequestDTO.getPassword(), encodedPassword);
            if (!result) {
                throw new QuoraException("Password doesn't matches");}

            UserDetails userDetails = userDetailsService.loadUserByUsername
                    (aes.encryptText("AES",loginUserRequestDTO.getEmail()));
            String tok = jwtUtil.generateToken(userDetails);
            System.out.println(tok);
           // String jwtToken = aes.encryptText("AES", tok);

            return this.setterForLoginUserResponseDTO(tok, users);
        } catch (Exception e){
            throw new QuoraException(e.getMessage());

        }
    }
    private  LoginUserResponseDTO setterForLoginUserResponseDTO(String jwtToken, Users users){
        LoginUserResponseDTO loginUserResponseDTO = new LoginUserResponseDTO();
        loginUserResponseDTO.setToken(jwtToken);
        loginUserResponseDTO.setUname(users.getName());
        return loginUserResponseDTO;
    }


}
