package com.una.linkhub.model;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.una.linkhub.model.pk.UserRoomPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_user_room")
public class UserRoom implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private @Getter @Setter UserRoomPK userRoomPK;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private @Getter @Setter User user;
	
	@ManyToOne
	@MapsId("roomId")
	@JoinColumn(name = "room_id")
	@JsonIgnore
	private @Getter @Setter Room room;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private @Getter @Setter Instant moment;

	public UserRoom() {}

	public UserRoom(User user, Room room, Instant moment) {
		this.userRoomPK = new UserRoomPK(user.getId(), room.getId());
		this.user = user;
		this.room = room;
		this.moment = moment;
	}
	
	
}
