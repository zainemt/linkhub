package com.una.linkhub.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class RoomCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Getter @Setter UUID id;
	private @Getter @Setter String roomName;
	
	public RoomCreateDTO() {}
	public RoomCreateDTO(UUID id, String roomName) {
		this.id = id;
		this.roomName = roomName;
	}
	
	
}
