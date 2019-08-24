package isa.projekat.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import isa.projekat.booking.domain.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
	
//	public List<Room> findAll();
//	
//	public Optional<Room> findById(String id);
}
