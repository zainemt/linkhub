package com.una.linkhub.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.una.linkhub.model.Link;
import com.una.linkhub.model.User;

import lombok.Getter;
import lombok.Setter;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter UUID id;
	private @Getter @Setter String username;
	private @Getter @Setter String email;

	private @Getter @Setter Set<Link> links = new HashSet<>();
	
	public UserDTO() {};
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getCredenciais().getUsername();
		this.email = user.getEmail();
		this.links = user.getLinks();
	}

}
