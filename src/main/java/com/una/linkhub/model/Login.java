package com.una.linkhub.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_login")
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private @Getter @Setter UUID id;
	
	@Column(unique = true)
	private @Getter @Setter String username;
	private @Getter @Setter String password;
	
	@OneToOne
	@MapsId
	@JsonIgnore
	private @Getter @Setter User user;
	
	public Login() {}

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
