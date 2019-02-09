package isa.projekat.booking.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Rooms")
public class Room {
	
	@Id
	private String id;
	private RoomStatus status;	
	private RoomType type;
	private int capacity;
	//private int pricePerNight;
	private int floor;
	private Double rating;
	private ArrayList<AdditionalService> additionalServices;
	private ArrayList<Price> prices;
	
	public Room() {
		super();
	}
	
	public Room(String id, RoomStatus status, RoomType type, int capacity,  int floor, Double rating,
			ArrayList<AdditionalService> additionalServices, ArrayList<Price> prices) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.capacity = capacity;
		//this.pricePerNight = pricePerNight;
		this.floor = floor;
		this.rating = rating;
		this.additionalServices = additionalServices;
		this.prices = prices;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double d) {
		this.rating = d;
	}

	public ArrayList<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(ArrayList<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public ArrayList<Price> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}
	
	
}
