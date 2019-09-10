package isa.projekat.booking.service;

import java.util.ArrayList;
import java.util.List;

import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.RoomType;

public interface IRoomService {
	
	Room save(Room room);
	Room findById(String id);
//	void deleteById(String id);
	Room deleteRoom(String id);
	List<Room> findAll();
	ArrayList<Room> getAll();
	
	List<Room> findByRoomType(RoomType type);
	List<Room> findByRoomCapacity(Integer capacity);
	List<Room> findByRoomTypeAndCapacity(RoomType type, Integer capacity);
}
