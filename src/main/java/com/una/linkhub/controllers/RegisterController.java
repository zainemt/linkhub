package com.una.linkhub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.linkhub.dto.UserDTO;
import com.una.linkhub.model.User;
import com.una.linkhub.services.RegisterService;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping
	public ResponseEntity<UserDTO> registerUser(@RequestBody User user) {
		UserDTO userDTO = registerService.RegisterUser(user);
		return ResponseEntity.ok().body(userDTO);
	}

	
	
}
