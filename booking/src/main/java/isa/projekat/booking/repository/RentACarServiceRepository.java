package isa.projekat.booking.repository;

import isa.projekat.booking.domain.RentACarService;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentACarServiceRepository extends MongoRepository<RentACarService, String> {
	
	@Query(" { $text : { $search : ?0, $language: 'none' } } ")
	List<RentACarService> findByName(String searchInput);
}
