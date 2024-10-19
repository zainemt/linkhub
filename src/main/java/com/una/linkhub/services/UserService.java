package com.una.linkhub.services;

import java.util.List;
import java.util.Optional;

import com.una.linkhub.model.User;
import com.una.linkhub.repositories.UserRepository;

public class UserService {
	
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}

}
