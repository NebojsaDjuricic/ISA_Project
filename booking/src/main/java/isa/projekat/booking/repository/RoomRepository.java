package isa.projekat.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.RoomType;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
	
//	public List<Room> findAll();
//	
//	public Optional<Room> findById(String id);
	
	@Query("{ 'type' : ?0 }")
	List<Room> findByRoomType(RoomType type);
	
	@Query("{ 'capacity' : ?0 }")
	List<Room> findByRoomCapacity(Integer capacity);
	
	@Query("{ 'type' : ?0, 'capacity' : ?1 }")
	List<Room> findByRoomTypeAndCapacity(RoomType type, Integer capacity);
}
