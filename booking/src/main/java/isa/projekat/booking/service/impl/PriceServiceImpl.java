package isa.projekat.booking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.Price;
import isa.projekat.booking.domain.Room;
import isa.projekat.booking.domain.dto.PriceDTO;
import isa.projekat.booking.repository.PriceRepository;
import isa.projekat.booking.repository.RoomRepository;
import isa.projekat.booking.service.IPriceService;

@Service
public class PriceServiceImpl implements IPriceService{
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Price> findAll() {
		return priceRepository.findAll();
	}
	
	@Override
	public Price save(Price price) {
		return priceRepository.save(price);
	}

	@Override
	public Price findById(String id) {
		Price retVal;
		Optional<Price> byId = priceRepository.findById(id);
		retVal = byId.get();
		
		return retVal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Price> findPriceForRoom(String id) {
		return (List<Price>) roomRepository.findById(id).get();
	}

//	@Override
//	public Price deletePrice(String id) {
////		Optional<Price> deletedPrice = priceRepository.findById(id);
////		priceRepository.delete(deletedPrice);
////		return deletedPrice;
//		
//		return null;
//	}
//
//	@Override
//	public Price createPriceForRoom(Price priceDto, String id) {
//		boolean exists = false;
//
//		for (Price price : roomRepository.findById(id).get()) {
//			if (priceDto.getStartDate().isAfter(price.getStartDate())
//					|| priceDto.getEndDate().isBefore(price.getEndDate())) {
//				exists = true;
//			}
//		}
//
//		if (!exists) {
//			Price newPrice = priceDto.createPrice(priceDto);
//			
//			roomRepository.findById(id).getPrices().add(newPrice);
//			priceRepository.save(newPrice);
//		}
//		return null;
//	}

}
