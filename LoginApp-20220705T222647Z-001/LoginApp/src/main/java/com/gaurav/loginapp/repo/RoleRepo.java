package com.gaurav.loginapp.repo;

import com.gaurav.loginapp.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Roles,Integer> {

}
