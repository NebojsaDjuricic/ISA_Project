package isa.projekat.booking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.Room;
import isa.projekat.booking.repository.RoomRepository;
import isa.projekat.booking.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public Room save(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Room findById(String id) {
		Room retVal;
		Optional<Room> byId = roomRepository.findById(id);
		retVal = byId.get();
		
		return retVal;
	}

	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

}
