package isa.projekat.booking.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
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

import com.mongodb.internal.thread.DaemonThreadFactory;

import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.domain.Branch;
import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.RentACarService;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.dto.BranchDTO;
import isa.projekat.booking.domain.dto.HotelDTO;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;
import isa.projekat.booking.domain.dto.RoomDTO;
import isa.projekat.booking.repository.HotelRepository;
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
		ArrayList<Hotel> hotels = hotelService.getAll();
		
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
	public ResponseEntity<Object> addHotel(@RequestBody Hotel hotelDto) {
		
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
		newHotel.setNumberOfFloors(hotelDto.getNumberOfFloors());
		newHotel.setStars(hotelDto.getStars());
		newHotel.setWebsite(hotelDto.getWebsite());
		newHotel.setContactEmail(hotelDto.getContactEmail());
		newHotel.setPhoneNumber(hotelDto.getPhoneNumber());
//		newHotel.setImageURL(null);
		
		hotelService.save(newHotel);
		
		return new ResponseEntity<>(newHotel, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value="/{hotelId}/rooms",
			method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> getRooms(@PathVariable("hotelId")String hotelId) {
		
		Hotel hotel = hotelService.findById(hotelId);
		
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ArrayList<Room> rooms = hotel.getRooms();
		
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/delete/{hotelId}/{roomId}",
			method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Room> deleteRoom(@PathVariable("hotelId")String hotelId,
			@PathVariable("roomId") String roomId) {
		
		Hotel hotel = hotelService.findById(hotelId);
		Room room = roomService.findById(roomId);
		
		
		ArrayList<Room> hotelRooms = hotel.getRooms();
		
		hotelRooms.remove(room);
		boolean obrisano = hotelRooms.remove(room);
		System.out.println("obrisano: " + obrisano);
		hotel.setRooms(hotelRooms);
		
		hotelService.save(hotel);
		Room deletedRoom = roomService.deleteRoom(roomId);
		
		if (deletedRoom != null) {
			return new ResponseEntity<Room>(deletedRoom, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") String id) {
		
		Hotel deletedHotel = hotelService.deleteHotel(id);

		if (deletedHotel != null) {
			return new ResponseEntity<Hotel>(deletedHotel, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
		
	@RequestMapping(
			value="/{adminId}/hotels",
			method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> getAdminHotels(@PathVariable("adminId")String adminId) {
		
		Administrator admin = administratorService.findById(adminId);
		String hotelID = admin.getEditingObjectID();
		Hotel hotel = hotelService.findById(hotelID);
		
//		ArrayList<Room> rooms = hotel.getRooms();
		
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
}
