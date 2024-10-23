package com.una.linkhub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.linkhub.model.Login;
import com.una.linkhub.repositories.LoginRepository;
import com.una.linkhub.services.LoginService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody Login login) {
		//User connectedUser = service.login(login);
		String s = service.login(login);
		return ResponseEntity.ok().body(s);
	}
	
	
	@Autowired
	private LoginRepository repository;
	@GetMapping
	public ResponseEntity<List<Login>> get() {
		return ResponseEntity.ok().body(repository.findAll());
	}
}


