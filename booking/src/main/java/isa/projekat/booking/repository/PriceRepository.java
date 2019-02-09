package isa.projekat.booking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import isa.projekat.booking.domain.Price;

@Repository
public interface PriceRepository extends MongoRepository<Price, String> {
	
	public Optional<Price> findById(String id);
}
