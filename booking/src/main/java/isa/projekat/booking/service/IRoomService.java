package isa.projekat.booking.service;

import java.util.ArrayList;
import java.util.List;

import isa.projekat.booking.domain.Room;

public interface IRoomService {
	
	Room save(Room room);
	Room findById(String id);
//	void deleteById(String id);
	Room deleteRoom(String id);
	List<Room> findAll();
	ArrayList<Room> getAll();
}
