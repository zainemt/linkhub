package com.una.linkhub.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.linkhub.dto.RoomAddUserDTO;
import com.una.linkhub.dto.RoomCreateDTO;
import com.una.linkhub.model.Room;
import com.una.linkhub.model.User;
import com.una.linkhub.model.UserRoom;
import com.una.linkhub.repositories.RoomRepository;
import com.una.linkhub.repositories.UserRepository;
import com.una.linkhub.repositories.UserRoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private UserRoomRepository userRoomRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Room createRoom(RoomCreateDTO roomCreateDTO) {
		User user = userRepository.findById(roomCreateDTO.getId()).get();
		Room room = new Room(null, roomCreateDTO.getRoomName(), user);
		roomRepository.save(room);
		UserRoom userRoom = new UserRoom(user, room, Instant.now());
		userRoomRepository.save(userRoom);
		user.getRooms().add(userRoom);
		user.setRoomQuantity(user.getRoomQuantity() - 1);
		userRepository.save(user);
		return userRoom.getRoom();
	}
	
	public Room addUserOnRoom(RoomAddUserDTO addUser) {
		User user = userRepository.findById(addUser.getId()).get();
		Optional<Room> room = roomRepository.findById(addUser.getRoomId());
		
		UserRoom userRoom = new UserRoom(user, room.get(), Instant.now());
		userRoom.getRoom().getUsers().add(userRoom);
		userRoomRepository.save(userRoom);
		
		user.getRooms().add(userRoom);
		userRepository.save(user);
		roomRepository.save(room.get());
		return userRoom.getRoom();
	}
	
	public Room insert(Room room) {
		return roomRepository.save(room);
	}
	
}
