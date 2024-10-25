package com.una.linkhub.controllers;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.linkhub.dto.UserDTO;
import com.una.linkhub.model.Link;
import com.una.linkhub.model.Login;
import com.una.linkhub.model.User;
import com.una.linkhub.services.LoginService;
import com.una.linkhub.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> userList = service.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
		UserDTO user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{id}/completo")
	public ResponseEntity<User> findByIdreturnUser(@PathVariable UUID id) {
		User user = service.findByIdReturnUser(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{id}/links")
	public ResponseEntity<Set<Link>> getUserLinks(@PathVariable UUID id) {
		UserDTO user = service.findById(id);
		Set<Link> links = user.getLinks();
		return ResponseEntity.ok().body(links);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> findByCredenciais(@RequestBody Login credenciais) {
		User user = loginService.checkPassword(credenciais);
		return ResponseEntity.ok().body(service.userToDTO(user));
	}
	
	
}
