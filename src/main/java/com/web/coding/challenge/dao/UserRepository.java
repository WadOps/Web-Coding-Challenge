package com.web.coding.challenge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web.coding.challenge.models.User;

public interface UserRepository extends MongoRepository<User,String>{

}
