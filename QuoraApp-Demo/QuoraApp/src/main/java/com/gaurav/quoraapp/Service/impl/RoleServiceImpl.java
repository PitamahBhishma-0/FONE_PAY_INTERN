package com.gaurav.quoraapp.Service.impl;

import com.gaurav.quoraapp.Repo.RoleRepo;
import com.gaurav.quoraapp.Repo.UsersRepo;
import com.gaurav.quoraapp.Service.RoleService;
import com.gaurav.quoraapp.model.Roles;
import com.gaurav.quoraapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UsersRepo usersRepo;

    @Override
    public Roles addNewRole(Roles role) {
        return roleRepo.save(role);
    }

    @Override
    public Set< String > addRolesToUser(Long id, Set< String > roles) {
       /*Users user =usersRepo.findById(id).orElseThrow();
        roles.forEach(
                role->{
                    role=role.toUpperCase();
                    Roles roles=roleRepo.findRole
                }
        );
    }*/

        return null;
    }
}



