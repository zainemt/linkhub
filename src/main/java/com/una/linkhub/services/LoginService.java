package com.una.linkhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.linkhub.model.User;

@Service
public class LoginService {

	@Autowired
	private UserService userService;
	
	public boolean checkPassword(String username, String password) {
		
		//criptograr a senha que esta sendo recebida 
		//verificar se a senha criptografada é igual a criptografia do banco
		
		User user = userService.findByUsername(username);
		
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public String login(String username, String password) {
		if (checkPassword(username, password)) {
			//gerar token caso seja válido
			return "token do usuário + token do refresh";
		}
		else { return "inválido!";} 
	} 
}
