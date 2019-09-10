package isa.projekat.booking.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

import isa.projekat.booking.domain.AdditionalService;
import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.domain.Branch;
import isa.projekat.booking.domain.GPScoordinate;
import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.Price;
import isa.projekat.booking.domain.RentACarService;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.RoomReservation;
import isa.projekat.booking.domain.dto.BranchDTO;
import isa.projekat.booking.domain.dto.HotelDTO;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;
import isa.projekat.booking.domain.dto.RoomDTO;
import isa.projekat.booking.domain.dto.RoomSearchQuery;
import isa.projekat.booking.domain.dto.VehicleSearchQuery;
import isa.projekat.booking.repository.HotelRepository;
import isa.projekat.booking.service.IAdditionalServiceService;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IHotelService;
import isa.projekat.booking.service.IRoomReservationService;
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
	
	@Autowired
	private IAdditionalServiceService additionalServicesService;
	
	private IRoomReservationService roomResService;
	
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
	
	public LocalDate stringToDate(String date) {
	    	
	    	String[] token = date.split("-");
	    	
	    	int year = 0;
	    	int month = 0;
	    	int dayOfMonth = 0;
	    	
	    	month = Integer.parseInt(token[1]);
	    	dayOfMonth = Integer.parseInt(token[2]);
	    	year = Integer.parseInt(token[0]);
	    	
	    	LocalDate result = LocalDate.of(year, month, dayOfMonth);
	    	
	    	return result;
	}
	
	
	// ============ HOTEL SEARCH ===============	
	
    @RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> search(@RequestBody RoomSearchQuery query) {
		List<Hotel> result = new ArrayList<Hotel>();
		
		ArrayList<Hotel> hoteli = hotelService.getAll();
		
		for(int i=0; i<hoteli.size(); i++) {
			result.add(hoteli.get(i));
		}
		
//		for(int j=0; j<hoteli.size(); j++) {
//			System.out.println("[HotelController: pretraga]: "
//					+ "naziv hotela: " + hoteli.get(j).getName() + ", "
//					+ "adresa hotela: " + hoteli.get(j).getAddress().getCity()
//					+ " " + hoteli.get(j).getAddress().getCountry());
			for(Hotel h: hoteli) {
				if(!(h.getAddress().getCity().toLowerCase().contains(query.getCity()) || 
					 h.getAddress().getCountry().toLowerCase().contains(query.getCountry()) ||
					 h.getName().toLowerCase().contains(query.getHotelName()))) {
					result.remove(h);
					System.out.println("[HotelController: pretraga]: obrisan hotel sa nazivom - " + h.getName());
				}
			}
//		}
		
		boolean postojiTerminSoba;
		boolean postojiSoba;
		
		for (int i=0; i<result.size(); i++) {
			Hotel hotel = result.get(i);
			postojiSoba = false;
			
			if(hotel.getRooms().size() != 0) {
				for(Iterator<Room> iteratorSoba = hotel.getRooms().iterator(); iteratorSoba.hasNext();) {
					System.out.println("[HotelController: pretraga]: usao u for za prolazak kroz sobe; ima " + hotel.getRooms().size() + " soba.");
					Room soba = (Room) iteratorSoba.next();
					postojiTerminSoba = true;
					
						if(soba.getReservations().isEmpty()) {
							postojiTerminSoba = true;
							postojiSoba = true;
							//break;
						}else {
							System.out.println("[HotelController: pretraga]: postoje rezervacije za sobu; ima ih " + soba.getReservations().size() + ".");
							for(Iterator<RoomReservation> iteratorRezervacija = soba.getReservations().iterator(); iteratorRezervacija.hasNext();) {
								RoomReservation rezervacijaHotel = iteratorRezervacija.next();
//								System.out.println("[HotelController: pretraga]: zahtev:  datum dolaska: " + query.getCheckInDate() + ", datum odlaska: " + query.getCheckOutDate() + ".");
//								System.out.println("[HotelController: pretraga]: rezervacija: " +
//													rezervacijaHotel.getId() + ", datum dolaska: " +
//													rezervacijaHotel.getResStart() + ", datum odlaska: " + 
//													rezervacijaHotel.getResEnd() + ".");

								if ( //rezervacijaHotel.isAktivirana() && 
									(
										stringToDate(query.getCheckInDate()).equals(rezervacijaHotel.getResStart()) || 
										stringToDate(query.getCheckInDate()).equals(rezervacijaHotel.getResEnd()) || 
										stringToDate(query.getCheckOutDate()).equals(rezervacijaHotel.getResStart()) || 
										((rezervacijaHotel.getResStart()).isAfter(stringToDate(query.getCheckInDate())) && (rezervacijaHotel.getResStart()).isBefore(stringToDate(query.getCheckOutDate()))) || 
										(stringToDate(query.getCheckInDate()).isAfter(rezervacijaHotel.getResStart()) && stringToDate(query.getCheckInDate()).isBefore(rezervacijaHotel.getResEnd())) || 
										(stringToDate(query.getCheckOutDate()).isAfter(rezervacijaHotel.getResStart()) && stringToDate(query.getCheckOutDate()).isBefore(rezervacijaHotel.getResEnd()))
									)
								) {
									System.out.println("[HotelController: pretraga]: soba je zauzeta u trazenom periodu.");
									iteratorSoba.remove();
									postojiTerminSoba = false;
								}else {
									System.out.println("[HotelController: pretraga]: soba je slobodna u trazenom periodu.");
								}
							}
							
							if(postojiTerminSoba) {
								postojiSoba = true;
							}
						}
					//}
					
				}
				
				if(!postojiSoba) {
					result.remove(hotel);
					i--;
				}
			}
			
		}
		
		
		if(query.getGuests() != 0) {
			boolean postoji;
			
			for(int i=0; i<result.size(); i++) {
				postoji = false;
				Hotel hotel = result.get(i);
				System.out.println("[HotelController: pretraga]: hotel " + hotel.getName() + " ima " + hotel.getRooms().size() + " soba.");
				for(Iterator<Room> iteratorSoba = hotel.getRooms().iterator(); iteratorSoba.hasNext();) {
					Room soba = (Room) iteratorSoba.next();
					if(soba.getCapacity() <= query.getGuests()) {
						postoji = true;
						//break;
					} else {
						iteratorSoba.remove();					
					}
				}
				if(!postoji) {
					result.remove(hotel);
					i--;
				}
			}
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	// =======================
	
	
	
	@RequestMapping(
			value = "/ordinarySearch",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Collection<Hotel>> ordinarySearchHotel(@RequestBody OrdinarySearchDTO ordinarySearchDto) {
		
		ArrayList<Hotel> hotels =  (ArrayList<Hotel>) hotelService.ordinarySearchHotel(ordinarySearchDto);

		if (hotels != null) {
			return new ResponseEntity<Collection<Hotel>>(hotels, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@RequestMapping(value = "/pretraga", method = RequestMethod.PUT, produces = "application/json")
//	public ResponseEntity<Collection<Hotel>> searchByHotelNameAndCityAndCountry(String hotelName, String city, String country) {
//		
//		ArrayList<Hotel> hotels =  (ArrayList<Hotel>) hotelService.search(hotelName, city, country);
//
//		if (hotels != null) {
//			return new ResponseEntity<Collection<Hotel>>(hotels, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	
//	@RequestMapping(
//			value = "/search",
//			method = RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Collection<Hotel>> getHotelsSearch(
//				String hotelName,
//				String check_in,
//				String check_out,
//				int adults) throws ParseException{
//		
//		name_location = name_location.toLowerCase();
//		String[] search = name_location.split(" ");
//		
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date date_check_in = format.parse(check_in);
//		Date date_check_out = format.parse(check_out);
//		
//		Collection<Hotel> hotels = hotelService.search("%" + search[0] + "%");
//		Collection<Hotel> hoteli = pretraga(hotels, search, date_check_in, date_check_out, adults);
//		
//			
//		return new ResponseEntity<Collection<Hotel>>(hoteli, HttpStatus.OK);
//	}
	
	
	@RequestMapping(
            value="/addHotel",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> addHotel(@RequestBody Hotel hotelDto) {
		
		Hotel newHotel = new Hotel();
		newHotel.setId("hotel_" + hotelDto.getName() + "_" + hotelDto.getAddress().getCity());
		newHotel.setName(hotelDto.getName());
		newHotel.setRating(0.0);
		newHotel.setDescription(hotelDto.getDescription());
		Address address = new Address();
		address.setStreetName(hotelDto.getAddress().getStreetName());
		address.setBuildingNumber(hotelDto.getAddress().getBuildingNumber());
		address.setCity(hotelDto.getAddress().getCity());
		address.setCountry(hotelDto.getAddress().getCountry());
//		GPScoordinate gps = new GPScoordinate();
//		gps.setLatitude(address.getCoordinatePosition().getLatitude());
//		gps.setLongitude(address.getCoordinatePosition().getLongitude());
//		address.setCoordinatePosition(gps);
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
            value = "/editHotel",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Object> editHotel(@RequestBody Hotel hotel) {
		
		Hotel newHotel = new Hotel();
		newHotel.setId(hotel.getId());
		newHotel.setName(hotel.getName());
		
		
		Address address = new Address();
		address.setStreetName(hotel.getAddress().getStreetName());
		address.setBuildingNumber(hotel.getAddress().getBuildingNumber());
		address.setCity(hotel.getAddress().getCity());
		address.setCountry(hotel.getAddress().getCountry());
//		GPScoordinate gps = new GPScoordinate();
//		gps.setLatitude(address.getCoordinatePosition().getLatitude());
//		gps.setLongitude(address.getCoordinatePosition().getLongitude());
//		address.setCoordinatePosition(gps);
		newHotel.setAddress(hotel.getAddress());
		
		
//		newHotel.getAddress().setStreetName(hotel.getAddress().getStreetName());
//		newHotel.getAddress().setBuildingNumber(hotel.getAddress().getBuildingNumber());
//		newHotel.getAddress().setCity(hotel.getAddress().getCity());
//		newHotel.getAddress().setCountry(hotel.getAddress().getCountry());
//		newHotel.getAddress().getCoordinatePosition().setLatitude(hotel.getAddress().getCoordinatePosition().getLatitude());
//		newHotel.getAddress().getCoordinatePosition().setLongitude(hotel.getAddress().getCoordinatePosition().getLongitude());
	
		
		newHotel.setPhoneNumber(hotel.getPhoneNumber());
		newHotel.setContactEmail(hotel.getContactEmail());
		newHotel.setDescription(hotel.getDescription());
		newHotel.setWebsite(hotel.getWebsite());
		newHotel.setStars(hotel.getStars());
		newHotel.setNumberOfFloors(hotel.getNumberOfFloors());
		
		//rooms
		// additional services
		// images
		
		
		
//		Hotel hotel = hotelService.findById(hotelId);
//		ArrayList<Room> rooms = hotel.getRooms();
//		
//		for(int i = 0; i < rooms.size(); i++) {
//			if(rooms.get(i).getId().equals(newRoom.getId())) {
//				rooms.get(i).setStatus(newRoom.getStatus());
//				rooms.get(i).setPricePerNight(newRoom.getPricePerNight());
//				rooms.get(i).setType(newRoom.getType());
//				rooms.get(i).setCapacity(newRoom.getCapacity());
//				rooms.get(i).setFloor(newRoom.getFloor());
//				rooms.get(i).setRating(newRoom.getRating());
//				break;
//			}
//		}
//		
//		hotel.setRooms(rooms);
		
		hotelService.save(hotel);
		
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
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") String id) {
		
		Hotel deletedHotel = hotelService.deleteHotel(id);

		if (deletedHotel != null) {
			return new ResponseEntity<Hotel>(deletedHotel, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	@RequestMapping(
			value="/delete/{hotelId}/{roomId}",
			method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public ResponseEntity<Room> deleteRoom(@PathVariable("hotelId")String hotelId,
			@PathVariable("roomId") String roomId) {
		
		Hotel hotel = hotelService.findById(hotelId);
		
		ArrayList<Room> hotelRooms = hotel.getRooms();
		Iterator<Room> itrr = hotelRooms.iterator();
		while (itrr.hasNext())
		{
		    Room ro = itrr.next();
		    if (ro.getId().equals(roomId)) {
		        itrr.remove();
		        System.out.println("obrisao sobu ");
		        break;
		    }
		}
		
		
//		hotelRooms.remove(room);
//		boolean obrisano = hotelRooms.remove(room);
//		System.out.println("obrisano: " + obrisano);
		
		hotel.setRooms(hotelRooms);
		
		hotelService.save(hotel);
		Room deletedRoom = roomService.deleteRoom(roomId);
		
		if (deletedRoom != null) {
			return new ResponseEntity<Room>(deletedRoom, HttpStatus.OK);
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
