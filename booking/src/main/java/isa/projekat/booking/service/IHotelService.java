package isa.projekat.booking.service;

import java.util.ArrayList;
import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.domain.dto.OrdinarySearchDTO;

public interface IHotelService {
	
	Hotel save(Hotel hotel);
	Hotel findById(String id);
	ArrayList<Hotel> ordinarySearchHotel(OrdinarySearchDTO ordinarySearchDto);
	ArrayList<Hotel> getAll();
}
