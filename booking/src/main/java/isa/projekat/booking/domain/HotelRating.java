package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;

public class HotelRating {
	@Id
	private Long id;
	private User user;
	private Hotel hotel;
	private int ocena;
	
	public HotelRating() {}

	public HotelRating(Long id, User user, Hotel hotel, int ocena) {
		super();
		this.id = id;
		this.user = user;
		this.hotel = hotel;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	@Override
	public String toString() {
		return "HotelRating [id=" + id + ", user=" + user + ", hotel=" + hotel + ", ocena=" + ocena + "]";
	}

}
