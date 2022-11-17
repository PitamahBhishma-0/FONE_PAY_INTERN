package com.gaurav.quoraapp.Repo;

import com.gaurav.quoraapp.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleRepo extends JpaRepository< Roles, Long > {
    @Query(value = "select * from roles where roles.fk_user=:uid", nativeQuery = true)
    List<Roles> fetchRolesFromUserId(Long uid);



}
