package isa.projekat.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.Price;
import isa.projekat.booking.domain.dto.PriceDTO;

public interface IPriceService {
	
	List<Price> findAll();
	Price findById(String id);
	Price save(Price price);
	List<Price> findPriceForRoom(String id);
//	Price deletePrice(String id);
//	Price createPriceForRoom(Price price, String id);
}
