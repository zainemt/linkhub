package com.una.linkhub.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.una.linkhub.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, UUID> {
	
	Login findByUsername(String username);

}
