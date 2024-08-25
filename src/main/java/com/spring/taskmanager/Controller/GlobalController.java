package com.spring.taskmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.taskmanager.helper.Message;
import com.spring.taskmanager.model.User;
import com.spring.taskmanager.service.UserService;

import jakarta.validation.Valid;

@RestController
public class GlobalController {
	@Autowired
	private UserService userservice;
	@PostMapping("/register")
	public ResponseEntity<Message> CreateUser(@Valid @RequestBody User user){
		if(user==null) {
			return new  ResponseEntity<>(new Message(0, "User Must Not null"),HttpStatus.BAD_REQUEST); 
		}
		
		String registerUser = userservice.RegisterUser(user);
		return new ResponseEntity<>(new Message(1, registerUser),HttpStatus.OK);
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<Message> LoginUser(@Valid @RequestBody User user){
//		return userservice.LoginUser(user);
//	}
	
	

}
