package com.una.linkhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.linkhub.model.Login;
import com.una.linkhub.model.User;
import com.una.linkhub.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginRepository repository;
	
	public User checkPassword(Login login) {
		
		//criptograr a senha que esta sendo recebida 
		//verificar se a senha criptografada é igual a criptografia do banco
		
		Login credenciais = repository.findByUsername(login.getUsername());
		
		if (credenciais != null && credenciais.getPassword().equals(login.getPassword())) {
			return userService.findByCredenciais(credenciais);
		}
		return null;
	}
	
	public String login(Login login) {
		User user = checkPassword(login);
		System.out.println(user);
		if (user != null) {
			//gerar token caso seja válido
			return "conexão gerada";
		}
		else {return "inválido";} 
	}
}
