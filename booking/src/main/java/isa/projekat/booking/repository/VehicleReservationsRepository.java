package isa.projekat.booking.repository;

import isa.projekat.booking.domain.VehicleReservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReservationsRepository extends MongoRepository<VehicleReservation, Integer> {
}
