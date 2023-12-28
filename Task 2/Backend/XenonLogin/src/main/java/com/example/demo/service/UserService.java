package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;

public interface UserService 
{
	public User addUser(UserDTO userDTO);
	
	public User login(UserDTO userDTO);
}
