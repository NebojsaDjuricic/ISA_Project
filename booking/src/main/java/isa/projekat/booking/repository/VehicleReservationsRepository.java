package isa.projekat.booking.repository;

import isa.projekat.booking.domain.VehicleReservation;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReservationsRepository extends MongoRepository<VehicleReservation, Integer> {
	
	@Query(" {'vehicleID' : ?0, 'rentACarServiceID' : ?1 }")
	List<VehicleReservation> findByVehicleAndRentACarServiceIDs(String vehicleID, String rentACarServiceID);
}
