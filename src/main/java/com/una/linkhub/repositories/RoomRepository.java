package com.una.linkhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.una.linkhub.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
