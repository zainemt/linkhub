package com.una.linkhub.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter @Setter Login credenciais;
	
	private @Getter @Setter Integer roomQuantity;
	
	@OneToMany
	private @Getter Set<Link> links = new HashSet<>();
	
	public User() {}

	public User(Long id, String name, String email, Integer roomQuantity) {
		this.id = id;
		this.name = name;
		this.email = email;
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
