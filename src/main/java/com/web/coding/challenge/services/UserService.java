package com.web.coding.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.coding.challenge.dao.UserRepository;
import com.web.coding.challenge.models.User;

public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getOneById(String userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
