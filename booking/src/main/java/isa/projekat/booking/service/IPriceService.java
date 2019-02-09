package isa.projekat.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.Price;
import isa.projekat.booking.domain.dto.PriceDTO;

@Service
public interface IPriceService {
	
	List<Price> findAll();
	Price findById(String id);
	List<Price> findPriceForRoom(String id);
//	Price deletePrice(String id);
//	Price createPrice(PriceDTO priceDto, String id);
}
