package com.codingdojo.tvshows.Services;

import java.util.ArrayList;


import java.util.Optional;
import org.springframework.stereotype.Service;

import com.codingdojo.tvshows.Models.User;
import com.codingdojo.tvshows.Repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
//	C - Create
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
//	R - Read

	public ArrayList<User> findAllUsers(){
		return (ArrayList<User>) userRepo.findAll();
	}
	
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepo.findUserById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	
	public User findByFirstName(String firstName) {
		return userRepo.findByFirstName(firstName);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
//	U - Updated
	public User updateUser(User diffUser) {
		return userRepo.save(diffUser);
	}
	
//	D - Delete
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
}
