package com.gaurav.quoraapp.Repo;

import com.gaurav.quoraapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepo extends JpaRepository< Users, Long > {

    @Query(value = "select * from users where email =:email ",nativeQuery = true)
    Users findUsersByEmail(String email);

    Users findByEmail(String email);

    @Query(value = "select * from users ",nativeQuery = true)
    List<Users> fetchAllUsers();
 /*   @Query(value = "select * from users", nativeQuery = true)
    List<Users> fetchAll();*/

}
