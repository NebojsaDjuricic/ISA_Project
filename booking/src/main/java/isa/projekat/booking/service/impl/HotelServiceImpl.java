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
		
		return hotelRepository.deleteByIdAndRoomsId(hotel.getId(), room.getId());
	}
	
//	@Override
//    public Mono<Project> addDeveloperToProject(String id, Developer developer) {
//
//        Mono<Project> fallback = Mono
//                .error(new ResourceNotFoundException("ADD DEVELOPER TO PROJECT: Project with id=" + id + " does not exists or developer with username:" +  developer.getUsername() + " is already added"));
//
//        return projectRepository.findByIdAndDevelopersNotIn(id, developer)
//                .switchIfEmpty(fallback)
//                .flatMap(existingProject-> {
//                    existingProject.getDevelopers().add(developer);
//                    return projectRepository.save(existingProject);
//                });
//    }
//	
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
		//ArrayList<Hotel> hotelRating = null;
//		ArrayList<Hotel> hotelDate = null;
		
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
		
		
		return hotels;
	
	}



	

}
