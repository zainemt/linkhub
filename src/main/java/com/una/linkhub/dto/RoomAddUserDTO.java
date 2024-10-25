package com.una.linkhub.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class RoomAddUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Getter @Setter UUID id;
	private @Getter @Setter Long roomId;
	
	public RoomAddUserDTO() {}
	public RoomAddUserDTO(UUID id, Long roomId) {
		this.id = id;
		this.roomId = roomId;
	}
	
	
}
