package isa.projekat.booking.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("RoomReservations")
public class RoomReservation {
	
	@Id
	private String id;	
	private LocalDate resStart;
	private LocalDate resEnd;
	private Integer noOfNights;
	private Integer noOfGuests;
	private String userID;
	private String roomID;
	private String hotelID;
//	private User reservedByUser;
//	private Room reservedRoom;
	private ArrayList<AdditionalService> additionalServices;
	
	// price = br nocenja * cena sobe po noci * br gostiju + usluge
	private Double price;
	
	// rating ?
	private Double rating;
	
	public RoomReservation() {
		this.setId("room_res_" + UUID.randomUUID().toString().substring(0, 7));
	}

	public RoomReservation(
			String id, LocalDate resStart, LocalDate resEnd,
			Integer noOfNights, Integer noOfGuests,
			String reservedByUserID, String reservedRoomID, 
			String hotelID, ArrayList<AdditionalService> additionalServices,
			Double price, Double rating
			) {
		super();
		this.id = id;
		this.resStart = resStart;
		this.resEnd = resEnd;
		this.noOfNights = noOfNights;
		this.noOfGuests = noOfGuests;
		this.userID = reservedByUserID;
		this.roomID = reservedRoomID;
		this.hotelID = hotelID;
		this.additionalServices = additionalServices;
		this.price = price;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getResStart() {
		return resStart;
	}

	public void setResStart(LocalDate resStart) {
		this.resStart = resStart;
	}

	public LocalDate getResEnd() {
		return resEnd;
	}

	public void setResEnd(LocalDate resEnd) {
		this.resEnd = resEnd;
	}

	public Integer getNoOfNights() {
		return noOfNights;
	}

	public void setNoOfNights(Integer noOfNights) {
		this.noOfNights = noOfNights;
	}

	public Integer getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(Integer noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public ArrayList<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(ArrayList<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}
