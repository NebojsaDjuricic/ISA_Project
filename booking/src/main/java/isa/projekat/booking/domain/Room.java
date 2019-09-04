package isa.projekat.booking.domain;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Rooms")
public class Room {
	
	@Id
	private String id;
//	status mozda bool
	private RoomStatus status;	
//	izbaciti type ?
	private RoomType type;
	private Integer capacity;
	private Integer floor;
	private ArrayList<Price> prices;
	private Double rating;
	
	private Boolean onDiscount;	
//	ako je onDiscount == true ?
//	private ArrayList<AdditionalService> additionalServices;
	private ArrayList<RoomRating> roomRatings;
	private ArrayList<RoomReservation> reservations;
	
	public Room() {
		super();
	}
	
	public Room(String id, RoomStatus status, 
			RoomType type, Integer capacity, Integer floor, Double rating) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.capacity = capacity;
		this.floor = floor;
		this.rating = rating;
	}
	
	public Room(String id, RoomStatus status, 
				RoomType type, Integer capacity, Integer floor,
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

	public Room(String id, RoomStatus status, RoomType type, Integer capacity, Integer floor, ArrayList<Price> prices,
			Double rating, Boolean onDiscount, ArrayList<RoomRating> roomRatings,
			ArrayList<RoomReservation> reservations) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.capacity = capacity;
		this.floor = floor;
		this.prices = prices;
		this.rating = rating;
		this.onDiscount = onDiscount;
		this.roomRatings = roomRatings;
		this.reservations = reservations;
	}

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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public ArrayList<Price> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Boolean isOnDiscount() {
		return onDiscount;
	}

	public void setOnDiscount(Boolean onDiscount) {
		this.onDiscount = onDiscount;
	}

	public ArrayList<RoomRating> getRoomRatings() {
		return roomRatings;
	}

	public void setRoomRatings(ArrayList<RoomRating> roomRatings) {
		this.roomRatings = roomRatings;
	}

	public ArrayList<RoomReservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<RoomReservation> reservations) {
		this.reservations = reservations;
	}

	
}
