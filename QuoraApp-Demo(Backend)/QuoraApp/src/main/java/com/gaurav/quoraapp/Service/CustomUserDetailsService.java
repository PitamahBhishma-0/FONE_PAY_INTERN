//package com.gaurav.quoraapp.Service;
//
//
//import com.gaurav.quoraapp.Dto.CustomUserDetails;
//import com.gaurav.quoraapp.Repo.UsersRepo;
//import com.gaurav.quoraapp.error.QuoraException;
//import com.gaurav.quoraapp.model.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UsersRepo usersRepo;
//
//    @Override
//    //username as email
//    public UserDetails loadUserByUsername(String username) {
//        try {
//            Users users = usersRepo.findByEmail(username);
//            if (users == null) {
//                throw new QuoraException("User doesn't exist");
//            }
//            return new CustomUserDetails(users);
//        } catch (Exception e) {
//            throw new QuoraException(e.getMessage());
//        }
//    }
//}
