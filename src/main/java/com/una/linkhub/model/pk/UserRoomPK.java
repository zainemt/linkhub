package com.una.linkhub.model.pk;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class UserRoomPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "user_id")
	private @Getter @Setter UUID userId;
	
	@JoinColumn(name = "room_id")
	private @Getter @Setter Long roomId;
	
	public UserRoomPK() {}
	
	public UserRoomPK(UUID userId, Long roomId) {
		this.userId = userId;
		this.roomId = roomId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoomPK other = (UserRoomPK) obj;
		return Objects.equals(roomId, other.roomId) && Objects.equals(userId, other.userId);
	}
	
}
