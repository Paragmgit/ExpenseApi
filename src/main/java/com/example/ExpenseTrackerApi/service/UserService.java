package com.example.ExpenseTrackerApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ExpenseTrackerApi.dao.UserRepository;
import com.example.ExpenseTrackerApi.model.User;

import jakarta.validation.Valid;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User createUser(@Valid User user) {
		return userRepository.save(user);
	}

	public User getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User updateUser(Integer userId,@Valid User user) {
		User newUser = userRepository.findById(userId).get();
		newUser.setUserName(user.getUserName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		return userRepository.save(newUser);
	}

	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

}
