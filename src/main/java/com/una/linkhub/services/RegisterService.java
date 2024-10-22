package com.una.linkhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.linkhub.dto.UserDTO;
import com.una.linkhub.model.User;

@Service
public class RegisterService {
	
	@Autowired
	private UserService userService;
	
	public UserDTO RegisterUser(User user) {
		//criptografar a senha enviada pelo usuário
		User registeredUser = userService.insert(user);
		return new UserDTO(registeredUser.getId(), registeredUser.getCredenciais().getUsername(), registeredUser.getEmail());
	}

}
