package com.una.linkhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.una.linkhub.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

}
