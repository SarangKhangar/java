package com.zensar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.bean.User;
import com.zensar.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/adduser")
	public User f1(@RequestBody User user) {
		return this.service.addUser(user);
	}
	
	@DeleteMapping("/deletuser")
	public User f2(@RequestBody User user, @PathVariable (name="id") String id) {
		return this.service.removeUser(user);
	}

}
