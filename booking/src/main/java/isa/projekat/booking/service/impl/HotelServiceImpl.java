package isa.projekat.booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;
import isa.projekat.booking.repository.HotelRepository;
import isa.projekat.booking.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public Hotel save(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	@Override
	public Hotel deleteHotel(String id) {
		Hotel del = findById(id);
		hotelRepository.delete(del);
		
		return del;
	}
	
	@Override
	public Hotel deleteByIdAndRoomsId(String hotelId, String roomId) {
		Hotel hotel = findById(hotelId);
		
		Room room = hotelRepository.findRoomById(roomId);
		
		
//		ArrayList<Room> rooms = hotel.getRooms();
//		Iterator<Room> itrr = rooms.iterator();
//		while (itrr.hasNext())
//		{
//		    Room ro = itrr.next();
//		    if (ro.getId().equals(roomId)) {
//		        itrr.remove();
//		        break;
//		    }
//		}
		
		
		return hotelRepository.deleteByIdAndRoomsId(hotel.getId(), room.getId());
	}
		
	@Override
	public ArrayList<Hotel> getAll() {
		List<Hotel> hotels = hotelRepository.findAll();
		
		return (ArrayList<Hotel>) hotels;			
	}

	@Override
	public Hotel findById(String id) {
		Hotel retVal;
		Optional<Hotel> byId = hotelRepository.findById(id);
		retVal = byId.get();
		
		return retVal;
	}
		
	public ArrayList<Hotel> ordinarySearchHotel(OrdinarySearchDTO ordinarySearchDto) {
		ArrayList<Hotel> hotels = null;
		ArrayList<Hotel> hotelNumerOfPerson = null;
		ArrayList<Hotel> hotelDate = null;
		
		if (ordinarySearchDto.getCity() == null && ordinarySearchDto.getHotelName() == null
				&& ordinarySearchDto.getCountry() == null) {
			hotels = (ArrayList<Hotel>) hotelRepository.findAll();
			System.out.println("Nije pronadjen hotel sa unetim gradom/imenom/drzavom");
			
		} else if (ordinarySearchDto.getHotelName() != null && ordinarySearchDto.getCity() == null
				&& ordinarySearchDto.getCountry() == null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByName(ordinarySearchDto.getHotelName());
			System.out.println("Pronadjen hotel sa imenom " + ordinarySearchDto.getHotelName());
			
		} else if (ordinarySearchDto.getHotelName() == null && ordinarySearchDto.getCity() != null
				&& ordinarySearchDto.getCountry() == null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByAddressCity(ordinarySearchDto.getCity());
			System.out.println("Pronadjen hotel u gradu " + ordinarySearchDto.getCity());
			
		} else if (ordinarySearchDto.getHotelName() == null && ordinarySearchDto.getCity() == null
				&& ordinarySearchDto.getCountry() != null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByAddressCountry(ordinarySearchDto.getCountry());
			System.out.println("Pronadjen hotel u zemlji " + ordinarySearchDto.getCountry());
			
		} else if (ordinarySearchDto.getHotelName() != null && ordinarySearchDto.getCity() != null
				&& ordinarySearchDto.getCountry() == null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByNameAndAddressCity(ordinarySearchDto.getHotelName(), ordinarySearchDto.getCity());
			System.out.println("Pronadjen hotel sa imenom " + ordinarySearchDto.getHotelName()
			+ " u gradu " + ordinarySearchDto.getCity());
			
		} else if (ordinarySearchDto.getHotelName() == null && ordinarySearchDto.getCity() != null
				&& ordinarySearchDto.getCountry() != null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByAddressCityAndAddressCountry(ordinarySearchDto.getCity(), ordinarySearchDto.getCountry());
			System.out.println("Pronadjen hotel u gradu " + ordinarySearchDto.getCity()
			+ " u zemlji " + ordinarySearchDto.getCountry());
			
		} else if (ordinarySearchDto.getHotelName() != null && ordinarySearchDto.getCity() == null
				&& ordinarySearchDto.getCountry() != null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByNameAndAddressCountry(ordinarySearchDto.getHotelName(), ordinarySearchDto.getCountry());
			System.out.println("Pronadjen hotel sa imenom " + ordinarySearchDto.getHotelName()
			+ " u zemlji " + ordinarySearchDto.getCountry());
			
		} else if (ordinarySearchDto.getHotelName() != null && ordinarySearchDto.getCity() != null
				&& ordinarySearchDto.getCountry() != null) {
			hotels = (ArrayList<Hotel>) hotelRepository
					.findByNameAndAddressCityAndAddressCountry(ordinarySearchDto.getHotelName(), ordinarySearchDto.getCity(), ordinarySearchDto.getCountry());
			System.out.println("Pronadjen hotel sa imenom " + ordinarySearchDto.getHotelName()
			+ " u gradu " + ordinarySearchDto.getCity() + " u zemlji " + ordinarySearchDto.getCountry());
		}
		
//		if (ordinarySearchDto.getNumberOfPerson() != null && accommodations != null) {
//			System.out.println("numberOfPerson");
//			hotelNumerOfPerson = new ArrayList<Hotel>();
//			for (Hotel a : hotels) {
//				if (a.getNumberOfPerson() >= ordinarySearchDto.getNumberOfPerson()) {
//					accommodationNumerOfPerson.add(a);
//				}
//			}
//			if (accommodationNumerOfPerson != null) {
//				if (ordinarySearchDto.getEndDate() != null && ordinarySearchDto.getStartDate() != null) {
//					accommodationDate = new ArrayList<Accommodation>();
//					for (Accommodation a : accommodationNumerOfPerson) {
//						for (Price p : a.getPrices()) {
//							if (ordinarySearchDto.getEndDate().before(p.getEndDate())
//									&& ordinarySearchDto.getStartDate().after(p.getStartDate())
//									&& ordinarySearchDto.getStartDate().before(ordinarySearchDto.getEndDate())) {
//								if (accommodationDate != null) {
//									if (!accommodationDate.contains(a)) {
//										accommodationDate.add(a);
//									}
//								}
//							}
//						}
//					}
//				} else {
//					return accommodationNumerOfPerson;
//				}
//			}
//
//			return accommodationNumerOfPerson;
//
//		}
//
//		if (ordinarySearchDto.getEndDate() != null && ordinarySearchDto.getStartDate() != null
//				&& accommodations != null) {
//			accommodationDate = new ArrayList<Accommodation>();
//			for (Accommodation a : accommodations) {
//				for (Price p : a.getPrices()) {
//					if (ordinarySearchDto.getEndDate().before(p.getEndDate())
//							&& ordinarySearchDto.getStartDate().after(p.getStartDate())
//							&& ordinarySearchDto.getStartDate().before(ordinarySearchDto.getEndDate())) {
//						if (accommodationDate != null) {
//							if (!accommodationDate.contains(a)) {
//								accommodationDate.add(a);
//							}
//						}
//					}
//				}
//			}
//			return accommodationDate;
//		}
		
		
		return hotels;
	
	}

	@Override
	public List<Hotel> search(String hotelName, String city, String country) {
		return hotelRepository.findByNameAndAddressCityAndAddressCountry(hotelName, city, country);
	}



	

}
