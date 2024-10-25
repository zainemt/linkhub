package com.una.linkhub.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.UUID)
	private @Getter @Setter UUID id;
	
	private @Getter @Setter String name;
	
	@Column(unique = true)
	private @Getter String email;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.MERGE)
	private @Getter @Setter Login credenciais;
	
	private @Getter @Setter Integer roomQuantity;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private @Getter Set<Link> links = new HashSet<>();
	
	@OneToMany
	@JsonIgnore
	private @Getter @Setter Set<UserRoom> rooms = new HashSet<>();
	
	public User() {}

	public User(String name, String email, Login credenciais) {
		this.name = name;
		this.email = email;
		this.credenciais = credenciais;
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
