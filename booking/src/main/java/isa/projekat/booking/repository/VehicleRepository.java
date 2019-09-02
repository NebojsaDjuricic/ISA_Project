package isa.projekat.booking.repository;

import isa.projekat.booking.domain.Vehicle;
import isa.projekat.booking.domain.VehicleType;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
	
	@Query("{ 'vehicleType' : ?0 }")
	List<Vehicle> findByVehicleType(VehicleType type);
}
