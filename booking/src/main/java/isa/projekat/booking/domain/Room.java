package isa.projekat.booking.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document("Rooms")
public class Room {
	
	private String id;
//	status mozda bool
	private RoomStatus status;	
//	izbaciti type
	private RoomType type;
	private int capacity;
	private int floor;
	@JsonIgnore
	private ArrayList<Price> prices;
	private int pricePerNight;
	private Double rating;
	@JsonIgnore
	private ArrayList<RoomRating> roomRatings;
	@JsonIgnore
	private ArrayList<RoomReservation> reservations;
//	private Hotel hotel;
	
	public Room() {
		
	}
	
	public Room(String id, RoomStatus status, 
			RoomType type, int capacity, int floor,
			int pricePerNight, Double rating) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.capacity = capacity;
		this.floor = floor;
		this.pricePerNight = pricePerNight;
		this.rating = rating;
	}
	
	public Room(String id, RoomStatus status, 
				RoomType type, int capacity, int floor,
				ArrayList<Price> prices, Double rating) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.capacity = capacity;
		this.floor = floor;
		this.prices = prices;
		this.rating = rating;
	}

// dodato kom hotelu pripada
//	public Room(String id, RoomStatus status, 
//				RoomType type, int capacity, int floor,
//			 	ArrayList<Price> prices, Hotel hotel) {
//		super();
//		this.id = id;
//		this.status = status;
//		this.type = type;
//		this.capacity = capacity;
//		this.floor = floor;
//		this.prices = prices;
//		this.hotel = hotel;
//	}
//	
//	public Hotel getHotel() {
//		return hotel;
//	}
//
//	public void setHotel(Hotel hotel) {
//		this.hotel = hotel;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

//	public int getPricePerNight() {
//		return pricePerNight;
//	}
//
//	public void setPricePerNight(int pricePerNight) {
//		this.pricePerNight = pricePerNight;
//	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public ArrayList<Price> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}


	
	
}
