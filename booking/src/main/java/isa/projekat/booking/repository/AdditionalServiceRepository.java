package isa.projekat.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import isa.projekat.booking.domain.AdditionalService;

@Repository
public interface AdditionalServiceRepository extends MongoRepository<AdditionalService, String>{
	
	public AdditionalService findById(Long id);
}
