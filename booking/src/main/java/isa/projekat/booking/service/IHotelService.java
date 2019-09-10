package isa.projekat.booking.service;

import java.util.ArrayList;
import java.util.List;

import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;

public interface IHotelService {
	
	Hotel save(Hotel hotel);
	Hotel findById(String id);
	List<Hotel> ordinarySearchHotel(OrdinarySearchDTO ordinarySearchDto);
	ArrayList<Hotel> getAll();
	Hotel deleteHotel(String id);
//	Room deleteHotelRoom(String roomId);
	Hotel deleteByIdAndRoomsId(String id, String roomId);
//	Room findRoomById(String id);
	List<Hotel> search(String hotelName, String city, String country);
}
