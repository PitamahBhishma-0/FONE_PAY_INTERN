package com.gaurav.quoraapp.Service.impl;

import com.gaurav.quoraapp.Dto.CustomUser;
import com.gaurav.quoraapp.Repo.RoleRepo;
import com.gaurav.quoraapp.Repo.UsersRepo;
import com.gaurav.quoraapp.model.Users;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    RoleRepo roleRepo;

    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepo.findUsersByEmail(username);
        if (users == null) {
            throw new UsernameNotFoundException("user not found");
        } else {
            log.info("User found in db {}" + username);
        }
//        Collection< SimpleGrantedAuthority > authorities = new ArrayList<>();
//        roleRepo.fetchRolesFromUserId(users.getUid()).forEach(roles -> {
//            authorities.add(new SimpleGrantedAuthority(roles.getRole()));
//        });
//        return new User(users.getEmail(), users.getPassword(), authorities);}
        return new CustomUser(users, roleRepo);
    }
}

