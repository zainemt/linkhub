package com.una.linkhub.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.linkhub.model.Link;
import com.una.linkhub.model.User;
import com.una.linkhub.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> userList = service.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{id}/links")
	public ResponseEntity<Set<Link>> getUserLinks(@PathVariable Long id) {
		User user = service.findById(id);
		Set<Link> links = user.getLinks();
		return ResponseEntity.ok().body(links);
	}
	
}
