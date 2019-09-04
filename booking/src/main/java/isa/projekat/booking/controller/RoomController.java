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

import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.Price;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.dto.PriceDTO;
import isa.projekat.booking.domain.dto.RoomDTO;
import isa.projekat.booking.domain.dto.RoomSearchQuery;
import isa.projekat.booking.service.IHotelService;
import isa.projekat.booking.service.IPriceService;
import isa.projekat.booking.service.IRoomService;

@RestController
@RequestMapping("room")
@CrossOrigin(origins = "*")
public class RoomController {
	
	@Autowired
	private IRoomService roomService;
	
	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IPriceService priceService;
	
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
			newRoom.setPrices(roomDto.getPrices());
			

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
		newRoom.setPrices(roomDto.getPrices());
		newRoom.setType(roomDto.getType());
		newRoom.setCapacity(roomDto.getCapacity());
		newRoom.setFloor(roomDto.getFloor());
		newRoom.setRating(roomDto.getRating());
		
		roomService.save(newRoom);
		
		String hotelId = roomDto.getHotelID();
		
		Hotel hotel = hotelService.findById(hotelId);
		ArrayList<Room> rooms = hotel.getRooms();
		
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getId().equals(newRoom.getId())) {
				rooms.get(i).setStatus(newRoom.getStatus());
				rooms.get(i).setPrices(newRoom.getPrices());
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
	
	
//  ====================== Price ==================== //
	
	@RequestMapping(
            value="/prices/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> getPrice(@PathVariable("id")String id) {
		
		Price price = priceService.findById(id);
		
		return new ResponseEntity<>(price, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/prices",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Collection<Price>> getAllPrices() {
		ArrayList<Price> prices = (ArrayList<Price>) priceService.findAll();
		
		if(prices != null) {
			return new ResponseEntity<Collection<Price>>(prices, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
            value = "/prices/addPrice",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> addNewPrice(@RequestBody PriceDTO price) {
		
		Price newPrice = new Price();
		newPrice.setId(UUID.randomUUID().toString().substring(0, 5));
		newPrice.setPricePerNight(price.getPrice());
		newPrice.setStartDate(price.getStartDate());
		newPrice.setEndDate(price.getEndDate());
		newPrice.setNaPopustu(price.getNaPopustu());
		newPrice.setPopust(price.getPopust());
		
		priceService.save(newPrice);
		
		String roomID = price.getRoomId();
		Room room = roomService.findById(roomID);
		room.getPrices().add(newPrice);
		
		roomService.save(room);
		
		return new ResponseEntity<>(newPrice, HttpStatus.OK);
	}
	
	@RequestMapping(
            value = "/prices/editPrice",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> editPrice(@RequestBody PriceDTO priceDTO) {
		
		Price newPrice = new Price();
		newPrice.setId(UUID.randomUUID().toString().substring(0, 5));
		newPrice.setPricePerNight(priceDTO.getPrice());
		newPrice.setStartDate(priceDTO.getStartDate());
		newPrice.setEndDate(priceDTO.getEndDate());
		newPrice.setNaPopustu(priceDTO.getNaPopustu());
		newPrice.setPopust(priceDTO.getPopust());
		
		priceService.save(newPrice);
		
		String roomID = priceDTO.getRoomId();
		Room room = roomService.findById(roomID);
		ArrayList<Price> prices = room.getPrices();
		
		for(int i = 0; i < prices.size(); i++) {
			if(prices.get(i).getId().equals(newPrice.getId())) {
				prices.get(i).setPricePerNight(newPrice.getPricePerNight());
				prices.get(i).setStartDate(newPrice.getStartDate());
				prices.get(i).setEndDate(newPrice.getEndDate());
				prices.get(i).setNaPopustu(newPrice.isNaPopustu());
				prices.get(i).setPopust(newPrice.getPopust());
				break;
			}
		}
		
		room.setPrices(prices);
		
		roomService.save(room);
		
		return new ResponseEntity<>(newPrice, HttpStatus.OK);
	}
	
}
