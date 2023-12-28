package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addUser(UserDTO userDTO) 
	{
	    User user = new User(userDTO.getName(), userDTO.getUsername(), userDTO.getPassword());
	    return userRepo.save(user);
	}

	@Override
	public User login(UserDTO userDTO) {
		User user = userRepo.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		if (user == null) {
	        // Handle the case where the user is not found, e.g., throw an exception or return a special value
	        throw new RuntimeException("User not found");
	    }
		return user;
	}

}
