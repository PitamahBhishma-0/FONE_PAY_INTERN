package com.gaurav.loginapp.repo;

import com.gaurav.loginapp.Dto.UserDto;
import com.gaurav.loginapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<Users,Integer> {
    @Query
            ("SELECT email from Users")
    //email ma configure kasari garne ????
    public List<UserDto> getUserByEmail();
}

