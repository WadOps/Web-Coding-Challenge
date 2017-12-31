package com.web.coding.challenge.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.coding.challenge.models.User;
import com.web.coding.challenge.services.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ResponseEntity<List<User>> list() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(userService.createUser(user));
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<User> showShop(@PathVariable String id) {
		return ResponseEntity.ok(userService.getOneById(id));
	}
}
