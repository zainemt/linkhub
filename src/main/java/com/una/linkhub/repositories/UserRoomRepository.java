package com.una.linkhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.una.linkhub.model.UserRoom;
import com.una.linkhub.model.pk.UserRoomPK;

public interface UserRoomRepository extends JpaRepository<UserRoom, UserRoomPK>{

}
