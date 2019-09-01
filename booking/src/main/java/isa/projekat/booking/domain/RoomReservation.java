package isa.projekat.booking.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("RoomReservations")
public class RoomReservation {
	
	@Id
	private Long id;	
	private LocalDate resStart;
	private LocalDate resEnd;
	private int noOfNights;
	private int noOfGuests;
//	private String reservedByUserID;
//	private String reservedRoomID;
	private User reservedByUser;
	private Room reservedRoom;
	private ArrayList<AdditionalService> additionalServices;
	
	// price = br nocenja * cena sobe po noci * br gostiju + usluge
	private Double price;
	
	// rating ?
	
	public RoomReservation() {
		this.setId(Calendar.getInstance().getTimeInMillis());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
