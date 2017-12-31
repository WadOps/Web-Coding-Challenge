package com.web.coding.challenge.services;

import java.util.List;

import com.web.coding.challenge.models.User;

public interface IUserService {
	
	List<User> findAll();
	
	User getOneById(String userId);
	
	User createUser(User user);
}
