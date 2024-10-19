package com.una.linkhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.una.linkhub.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
