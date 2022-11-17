//package com.gaurav.quoraapp.Dto;
//
//import com.gaurav.quoraapp.model.Roles;
//import com.gaurav.quoraapp.model.Users;
//import com.gaurav.quoraapp.utils.AES;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//public class CustomUserDetails implements UserDetails {
//    @Autowired
//    private Users users;
//
//    @Autowired
//    private AES aes;
//
//    public CustomUserDetails(Users users) {
//        this.users = users;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        HashSet<SimpleGrantedAuthority> set = new HashSet<>();
////        set.add(new SimpleGrantedAuthority("ADMIN"));
//        return set;
//    }
//
//    @Override
//    public String getPassword() {
//        return users.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return users.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
////    public Long getId() {
////        return users.getUid();
////    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
