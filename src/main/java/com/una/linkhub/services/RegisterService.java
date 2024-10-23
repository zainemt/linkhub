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
		
		//adiciona o usuário no banco e retorna o usuário final, contendo id e demais informações
		User registeredUser = userService.insert(user);
		return new UserDTO(registeredUser);
	}

}
