package com.una.linkhub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.linkhub.dto.RoomAddUserDTO;
import com.una.linkhub.dto.RoomCreateDTO;
import com.una.linkhub.model.Room;
import com.una.linkhub.services.RoomService;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;

	@PostMapping(value = "/createroom")
	public ResponseEntity<Room> createRoom(@RequestBody RoomCreateDTO create) {
		Room createdRoom = roomService.createRoom(create);
		return ResponseEntity.ok().body(createdRoom);
	}
	
	@PostMapping(value = "/addonroom")
	public ResponseEntity<Room> addOnRoom(@RequestBody RoomAddUserDTO addUser) {
		Room room = roomService.addUserOnRoom(addUser);
		return ResponseEntity.ok().body(room);
	}
	
}
