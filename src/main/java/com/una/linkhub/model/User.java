package com.una.linkhub.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_users")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter String name;
	@Column(unique = true)
	private @Getter String email;
	@Column(unique = true)
	private @Getter @Setter String username;
	private @Getter String password;
	private @Getter @Setter Integer roomQuantity;
	
	@OneToMany
	@JoinColumn(name = "tb_links")
	private Set<User> links = new HashSet<>();
	
	public User() {}

	public User(Long id, String name, String email, String username, String password, Integer roomQuantity) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roomQuantity = roomQuantity;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", roomQuantity=" + roomQuantity + "]";
	}
	
}
