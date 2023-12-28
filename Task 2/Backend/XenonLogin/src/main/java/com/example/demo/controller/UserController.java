package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	
	
	
	@Autowired
	private UserService userService;
	

	
	@PostMapping("/addUser")
	public User addUser(@RequestBody UserDTO userDTO)
	//public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO)
	{
		User user = userService.addUser(userDTO);
					
		return user;
		
		
	}
	
	@PostMapping("/login")
	//public User login(@RequestBody UserDTO userDTO)
	public ResponseEntity<?> login(@RequestBody UserDTO userDTO)
	{
		User user = userService.login(userDTO);
		if(user !=null)
		{
			ResponseEntity<?> responseEntity = new ResponseEntity<>(user,HttpStatus.OK);
			return responseEntity;
		}
		else
		{
			ResponseEntity<?> responseEntity = new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
			return responseEntity;
		}
		
		
	}
	
	
}



