package com.una.linkhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.una.linkhub.model.Login;
import com.una.linkhub.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByCredenciais(Login credenciais);
}
