package isa.projekat.booking.domain;

import java.text.SimpleDateFormat;

public class RoomSearchResults {
	
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;
	private Integer guests;
    private Double price;
    private Room room;
    
    public RoomSearchResults() {
    	
    }

	public SimpleDateFormat getStartDate() {
		return startDate;
	}

	public void setStartDate(SimpleDateFormat startDate) {
		this.startDate = startDate;
	}

	public SimpleDateFormat getEndDate() {
		return endDate;
	}

	public void setEndDate(SimpleDateFormat endDate) {
		this.endDate = endDate;
	}

	public Integer getGuests() {
		return guests;
	}

	public void setGuests(Integer guests) {
		this.guests = guests;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
    
}
