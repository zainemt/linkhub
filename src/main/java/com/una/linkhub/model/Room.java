package com.una.linkhub.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_rooms")
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter Long id;
	
	private @Getter @Setter String name;
	
	@ManyToMany
	private @Getter @Setter Set<UserRoom> users = new HashSet<>();
	
	@OneToOne
	private @Getter @Setter User owner;

	public Room() {}
	public Room(Long id, String name, User owner) {
		this.id = id;
		this.name = name;
		this.owner = owner;
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
		Room other = (Room) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", user=" + users + "]";
	}

}
