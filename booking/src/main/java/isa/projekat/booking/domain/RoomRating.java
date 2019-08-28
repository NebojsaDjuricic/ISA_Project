package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;

public class RoomRating {
	@Id
	private Long id;
	private User user;
	private Room room;
	private int ocena;
	
	public RoomRating() {}
	
	public RoomRating(Long id, User user, Room room, int ocena) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.ocena = ocena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	@Override
	public String toString() {
		return "RoomRating [id=" + id + ", user=" + user + ", room=" + room + ", ocena=" + ocena + "]";
	}
	

}
