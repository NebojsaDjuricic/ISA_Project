package isa.projekat.booking.service;

import java.util.List;

import isa.projekat.booking.domain.Room;

public interface IRoomService {
	
	Room save(Room room);
	Room findById(String id);
	List<Room> findAll();
}
