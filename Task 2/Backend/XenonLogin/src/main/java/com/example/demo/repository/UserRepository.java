package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	public User findByUsernameAndPassword(String username, String password);
	
	public List<User> findByUsername(String username);
}
