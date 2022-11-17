package com.gaurav.quoraapp.controller;

import com.gaurav.quoraapp.Service.RoleService;
import com.gaurav.quoraapp.model.Roles;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/role")
public class RoleController {
    RoleService roleService;
    @PostMapping("/addRole")
    public ResponseEntity<Roles> addRole(@RequestBody Roles role){
        return  new ResponseEntity<>(roleService.addNewRole(role), HttpStatus.CREATED);
    }

}
