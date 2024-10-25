package com.una.linkhub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.linkhub.config.DotenvConfig;
import com.una.linkhub.dto.UserDTO;
import com.una.linkhub.model.Login;
import com.una.linkhub.model.User;
import com.una.linkhub.repositories.LoginRepository;
import com.una.linkhub.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	public List<UserDTO> findAll() {
		List<UserDTO> dtoList = new ArrayList<>();
		List<User> list = repository.findAll();
		for (User user : list) {
			dtoList.add(userToDTO(user));
		}
		return dtoList;
	}
	
	public UserDTO findById(UUID id) {
		Optional<User> user = repository.findById(id);
		return userToDTO(user.get());
	}
	
	public User findByCredenciais(Login credenciais) {
		return repository.findByCredenciais(credenciais);
	}
	
	public User insert(User user) {
		user.setRoomQuantity(Integer.parseInt(DotenvConfig.get("default_Room_Quantity")));
		user.getCredenciais().setUser(user);
		loginRepository.save(user.getCredenciais());
		return repository.save(user);
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public UserDTO userToDTO(User user) {
		return new UserDTO(user);
	}
	
	public User findByIdReturnUser(UUID id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
}
