package isa.projekat.booking.domain.dto;

import java.util.ArrayList;

import isa.projekat.booking.domain.AdditionalService;

public class RoomReservationDTO {
	
	private String roomId;
	private String hotelID;
	private String checkInDate;
	private String checkOutDate;
	private Double price;
//	private PriceDTO priceDTO;
//	private ArrayList<PriceDTO> pricesDTO;
	private Integer guests;
	private Integer nights;
	private Integer rooms;
	private ArrayList<AdditionalService> additionalServices;
	
	public RoomReservationDTO() {
		
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

//	public PriceDTO getPriceDTO() {
//		return priceDTO;
//	}
//
//	public void setPriceDTO(PriceDTO priceDTO) {
//		this.priceDTO = priceDTO;
//	}
//
//	public ArrayList<PriceDTO> getPricesDTO() {
//		return pricesDTO;
//	}
//
//	public void setPricesDTO(ArrayList<PriceDTO> pricesDTO) {
//		this.pricesDTO = pricesDTO;
//	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getGuests() {
		return guests;
	}

	public void setGuests(Integer guests) {
		this.guests = guests;
	}

	public Integer getNights() {
		return nights;
	}

	public void setNights(Integer nights) {
		this.nights = nights;
	}

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public ArrayList<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(ArrayList<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}
	

}
