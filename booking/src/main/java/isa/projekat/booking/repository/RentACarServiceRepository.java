package isa.projekat.booking.repository;

import isa.projekat.booking.domain.RentACarService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentACarServiceRepository extends MongoRepository<RentACarService, String> {
}
