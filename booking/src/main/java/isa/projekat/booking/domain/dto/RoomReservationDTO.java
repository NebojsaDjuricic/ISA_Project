package isa.projekat.booking.domain.dto;

import java.util.ArrayList;

public class RoomReservationDTO {
	
	private String roomId;
//	private String checkInDate;
//	private String checkOutDate;
//	private PriceDTO priceDTO;
	private ArrayList<PriceDTO> pricesDTO;
	private int guests;
	private int rooms;
	
	public RoomReservationDTO() {
		
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

//	public String getCheckInDate() {
//		return checkInDate;
//	}
//
//	public void setCheckInDate(String checkInDate) {
//		this.checkInDate = checkInDate;
//	}
//
//	public String getCheckOutDate() {
//		return checkOutDate;
//	}
//
//	public void setCheckOutDate(String checkOutDate) {
//		this.checkOutDate = checkOutDate;
//	}

//	public PriceDTO getPriceDTO() {
//		return priceDTO;
//	}
//
//	public void setPriceDTO(PriceDTO priceDTO) {
//		this.priceDTO = priceDTO;
//	}

	public ArrayList<PriceDTO> getPricesDTO() {
		return pricesDTO;
	}

	public void setPricesDTO(ArrayList<PriceDTO> pricesDTO) {
		this.pricesDTO = pricesDTO;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	

}
