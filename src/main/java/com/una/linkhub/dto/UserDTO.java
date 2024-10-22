package com.una.linkhub.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter UUID id;
	private @Getter @Setter String username;
	private @Getter @Setter String email;

	public UserDTO() {};
	
	public UserDTO(UUID id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}
	
	

}
