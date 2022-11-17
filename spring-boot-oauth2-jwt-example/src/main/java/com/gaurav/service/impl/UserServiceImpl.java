package com.gaurav.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gaurav.dao.UserRepo;
import com.gaurav.model.User;
import com.gaurav.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepo userDao;

	public UserDetails loadUserByUsername(String userName) {
		try {

			User user = userDao.findByUsername(userName);

			if (user == null) {
				throw new UsernameNotFoundException("Invalid username or password.");
			}

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					getAuthority());
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}
}
