package isa.projekat.booking.service;

import java.util.ArrayList;
import java.util.List;

import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.dto.HotelDTO;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;

public interface IHotelService {
	
	Hotel save(Hotel hotel);
	Hotel findById(String id);
	List<Hotel> findAll();
	ArrayList<Hotel> ordinarySearchHotel(OrdinarySearchDTO ordinarySearchDto);
	//Hotel createHotel(HotelDTO hotelDto);

}
