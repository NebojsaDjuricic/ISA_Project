package isa.projekat.booking.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.dto.HotelDTO;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IHotelService;
import isa.projekat.booking.service.IRoomService;
import isa.projekat.booking.service.impl.HotelServiceImpl;

@RestController
@RequestMapping("hotels")
@CrossOrigin(origins = "*")
public class HotelController {
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
    private IAdministratorService administratorService;
	
	@Autowired
	private IRoomService roomService;
	
	@RequestMapping( 
			
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Collection<Hotel>> getAllHotels() {
		ArrayList<Hotel> hotels = (ArrayList<Hotel>) hotelService.findAll();
		
		if(hotels != null) {
			return new ResponseEntity<Collection<Hotel>>(hotels, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( 
			value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id) {
		Hotel hotel = hotelService.findById(id);
		
		if(hotel != null) {
			return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/ordinarySearch", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Collection<Hotel>> ordinarySearchHotel(@RequestBody OrdinarySearchDTO ordinarySearchDto) {
		
		ArrayList<Hotel> hotels =  (ArrayList<Hotel>) hotelService.ordinarySearchHotel(ordinarySearchDto);

		if (hotels != null) {
			return new ResponseEntity<Collection<Hotel>>(hotels, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(
            value="/addHotel",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> addHotel(@RequestBody HotelDTO hotelDto) {
		
		Hotel newHotel = new Hotel();
		newHotel.setId(UUID.randomUUID().toString().substring(0, 5));
		newHotel.setName(hotelDto.getName());
		newHotel.setRating(0.0);
		newHotel.setDescription(hotelDto.getDescription());
		Address address = new Address();
		address.setStreetName(hotelDto.getAddress().getStreetName());
		address.setBuildingNumber(hotelDto.getAddress().getBuildingNumber());
		address.setCity(hotelDto.getAddress().getCity());
		address.setCountry(hotelDto.getAddress().getCountry());
		newHotel.setAddress(address);
		newHotel.setRooms(new ArrayList<>());
		newHotel.setAdditionalServices(new ArrayList<>());
		
		hotelService.save(newHotel);
		
		return new ResponseEntity<>(newHotel, HttpStatus.OK);
	}
}
