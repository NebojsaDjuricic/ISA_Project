package isa.projekat.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import isa.projekat.booking.domain.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
	
	public List<Hotel> findAll();
	
	public Optional<Hotel> findById(String id);
	
	public List<Hotel> findByName(String hotelName);
	
	public List<Hotel> findByAddressCity(String city);
	
	public List<Hotel> findByAddressCountry(String country);
	
	public List<Hotel> findByNameAndAddressCity(String hotelName, String city);
	
	public List<Hotel> findByNameAndAddressCountry(String hotelName, String country);
	
	public List<Hotel> findByAddressCityAndAddressCountry(String city, String country);
	
	public List<Hotel> findByNameAndAddressCityAndAddressCountry(String hotelName, String city, String country);
}
