package isa.projekat.booking.domain.dto;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import isa.projekat.booking.domain.AdditionalService;
import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.domain.Price;
import isa.projekat.booking.domain.RoomStatus;
import isa.projekat.booking.domain.RoomType;

public class RoomDTO {

	@Id
	private String id;
	private RoomStatus status;
	private RoomType type;
	private int capacity;
	private int floor;
	private ArrayList<Price> prices;
	private String hotelID;
	
	
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


	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	
}
