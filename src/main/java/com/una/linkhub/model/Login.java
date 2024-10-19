package com.una.linkhub.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String username;
	private @Getter @Setter String password;
	
	public Login() {}

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
