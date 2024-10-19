package com.una.linkhub.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_links")
public class Link implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	private @Getter @Setter String link;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private @Getter @Setter User user;
	
	public Link() {}

	public Link(Long id, String link, User user) {
		this.id = id;
		this.link = link;
		this.user = user;
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
		Link other = (Link) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", link=" + link + ", user=" + user + "]";
	}
	
}
