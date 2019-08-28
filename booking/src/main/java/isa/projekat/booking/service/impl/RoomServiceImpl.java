package isa.projekat.booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import isa.projekat.booking.domain.Room;
import isa.projekat.booking.repository.RoomRepository;
import isa.projekat.booking.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {
	
	private MongoDatabase baza;

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

////	@Override
//	public void deleteById(String id) {
//		roomRepository.deleteById(id);
//		
//	}
	
	@Override
	public Room deleteRoom(String id) {
		Room del = findById(id);
		roomRepository.delete(del);
		return del;
	}
	
	public void deleteRoom(Room room) {
		MongoCollection<Document> soba = baza.getCollection("Rooms");
		soba.deleteOne(eq("id",room.getId()));
	}

	@Override
	public ArrayList<Room> getAll() {
		return (ArrayList<Room>) roomRepository.findAll();
	}
	



}
