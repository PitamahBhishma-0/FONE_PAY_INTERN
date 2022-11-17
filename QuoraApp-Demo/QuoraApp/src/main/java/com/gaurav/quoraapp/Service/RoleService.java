package com.gaurav.quoraapp.Service;

import com.gaurav.quoraapp.model.Roles;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public interface RoleService {

    Roles addNewRole(Roles role);

    Set<String> addRolesToUser(Long id, Set<String> roles);


}
