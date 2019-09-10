package isa.projekat.booking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.RoomReservation;
import isa.projekat.booking.repository.RoomReservationRepository;
import isa.projekat.booking.service.IRoomReservationService;

@Service
public class RoomReservationServiceImpl implements IRoomReservationService {

	RoomReservationRepository roomReservationRepository;
	
	@Override
	public RoomReservation save(RoomReservation roomReservation) {
		return roomReservationRepository.save(roomReservation);
	}

	@Override
	public List<RoomReservation> findByRoomID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomReservation> findByRoomAndHotelID(String roomId, String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
