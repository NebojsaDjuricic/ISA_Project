package isa.projekat.booking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import isa.projekat.booking.domain.RoomReservation;

@Repository
public interface RoomReservationRepository extends MongoRepository<RoomReservation, Integer> {
	
	@Query(" {'roomId' : ?0, 'hotelId' : ?1 }")
	List<RoomReservation> findByRoomAndHotelID(String roomId, String hotelId);
	
}
