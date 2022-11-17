package com.gaurav.service;

import java.util.List;

import com.gaurav.model.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
