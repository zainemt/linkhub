package com.una.linkhub.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.linkhub.config.DotenvConfig;
import com.una.linkhub.model.Login;
import com.una.linkhub.model.User;
import com.una.linkhub.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(UUID id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User findByCredenciais(Login credenciais) {
		return repository.findByCredenciais(credenciais);
	}
	
	public User insert(User user) {
		user.setRoomQuantity(Integer.parseInt(DotenvConfig.get("default_Room_Quantity")));
		return repository.save(user);
	}

}
