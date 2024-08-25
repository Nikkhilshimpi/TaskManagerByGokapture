package com.spring.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.taskmanager.helper.Message;
import com.spring.taskmanager.model.User;
import com.spring.taskmanager.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userrepo;
	
	public String RegisterUser(User user) {
		try {
			user.setUser_password(passwordEncoder.encode(user.getUser_password()));
			userrepo.save(user);
			return "User Registered Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			return "User not Register";
		}
		
		
	}
	

}
