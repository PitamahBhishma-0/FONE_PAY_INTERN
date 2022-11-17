package com.gaurav.quoraapp.Dto;

import com.gaurav.quoraapp.Repo.RoleRepo;
import com.gaurav.quoraapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class CustomUser implements UserDetails {
    @Autowired
    Users users;

    @Autowired
    private final RoleRepo roleRepo;

    public CustomUser(Users user, RoleRepo roleRepo) {
        this.users = user;
        this.roleRepo = roleRepo;
    }



    @Override
    public Collection< ? extends GrantedAuthority > getAuthorities() {
        Collection< SimpleGrantedAuthority > authorities = new ArrayList<>();
        roleRepo.fetchRolesFromUserId(users.getUid()).forEach(roles -> {
            System.out.println(roles.getRole());
            authorities.add(new SimpleGrantedAuthority(roles.getRole()));
        });
        System.out.println(users.getUid());
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
