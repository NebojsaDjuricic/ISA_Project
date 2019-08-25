package isa.projekat.booking.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.RoomStatus;
import isa.projekat.booking.domain.RoomType;
import isa.projekat.booking.domain.dto.RoomDTO;
import isa.projekat.booking.domain.dto.RoomSearchQuery;
import isa.projekat.booking.repository.RoomRepository;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IHotelService;
import isa.projekat.booking.service.IRoomService;
import isa.projekat.booking.service.impl.RoomServiceImpl;

@RestController
@RequestMapping("room")
@CrossOrigin(origins = "*")
public class RoomController {
	
	@Autowired
	private IRoomService roomService;
	
	@Autowired
	private IHotelService hotelService;
	
	@RequestMapping(
            value="/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> getRoom(@PathVariable("id")String id) {
		
		Room room = roomService.findById(id);
		
		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@RequestMapping( 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Collection<Room>> getAllRooms() {
		ArrayList<Room> rooms = (ArrayList<Room>) roomService.findAll();
		
		if(rooms != null) {
			return new ResponseEntity<Collection<Room>>(rooms, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
            value = "/addRoom",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> addNewRoom(@RequestBody RoomDTO roomDto) {
		
//		Room fromDB = roomService.findById(roomDto.getId());
		
//		if(fromDB == null) {
			Room newRoom = new Room();
			newRoom.setId(roomDto.getId());
			newRoom.setStatus(roomDto.getStatus());
			newRoom.setType(roomDto.getType());
			newRoom.setCapacity(roomDto.getCapacity());
			newRoom.setFloor(roomDto.getFloor());
//			newRoom.setPrices(roomDto.getPrices());
			newRoom.setPricePerNight(roomDto.getPricePerNight());
			

	        // newRoom.setPrices(prices);
	        // newRoom.setHotel(hotel);
			
			roomService.save(newRoom);
			
			String hotelId = roomDto.getHotelID();
			Hotel hotel = hotelService.findById(hotelId);
			hotel.getRooms().add(newRoom);
			
			hotelService.save(hotel);
			
			return new ResponseEntity<>(newRoom, HttpStatus.OK);
//		}
		
//		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	@RequestMapping(
            value = "/editRoom",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> editRoom(@RequestBody RoomDTO roomDto) {
		
		Room newRoom = new Room();
		newRoom.setId(roomDto.getId());
		newRoom.setStatus(roomDto.getStatus());
		newRoom.setPricePerNight(roomDto.getPricePerNight());
		newRoom.setType(roomDto.getType());
		newRoom.setCapacity(roomDto.getCapacity());
		newRoom.setFloor(roomDto.getFloor());
		newRoom.setRating(roomDto.getRating());
		
		roomService.save(newRoom);
		
		String hotelId = roomDto.getHotelID();
//		String adminID = roomDto.getAdmin();
		
		Hotel hotel = hotelService.findById(hotelId);
		ArrayList<Room> rooms = hotel.getRooms();
		
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getId().equals(newRoom.getId())) {
				rooms.get(i).setStatus(newRoom.getStatus());
				rooms.get(i).setPricePerNight(newRoom.getPricePerNight());
				rooms.get(i).setType(newRoom.getType());
				rooms.get(i).setCapacity(newRoom.getCapacity());
				rooms.get(i).setFloor(newRoom.getFloor());
				rooms.get(i).setRating(newRoom.getRating());
				break;
			}
		}
		
		hotel.setRooms(rooms);
		
		hotelService.save(hotel);
		
		return new ResponseEntity<>(newRoom, HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Room> deleteRoom(@PathVariable String id) {
		
		Room deletedRoom = roomService.deleteRoom(id);

		if (deletedRoom != null) {
			return new ResponseEntity<Room>(deletedRoom, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	@RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> search(@RequestBody RoomSearchQuery query) {
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
}
