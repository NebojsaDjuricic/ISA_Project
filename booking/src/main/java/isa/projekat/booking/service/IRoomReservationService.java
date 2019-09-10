package isa.projekat.booking.service;

import java.util.List;

import isa.projekat.booking.domain.RoomReservation;

public interface IRoomReservationService {

	RoomReservation save(RoomReservation roomReservation);
	List<RoomReservation> findByRoomID(String id);
	List<RoomReservation> findByRoomAndHotelID(String roomId, String hotelId);
}
