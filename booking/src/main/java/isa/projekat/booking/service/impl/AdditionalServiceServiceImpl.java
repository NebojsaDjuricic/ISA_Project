package isa.projekat.booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.projekat.booking.domain.AdditionalService;
import isa.projekat.booking.domain.Hotel;
import isa.projekat.booking.repository.AdditionalServiceRepository;
import isa.projekat.booking.repository.HotelRepository;
import isa.projekat.booking.service.IAdditionalServiceService;

@Service
public class AdditionalServiceServiceImpl implements IAdditionalServiceService{

	@Autowired
	AdditionalServiceRepository additionalServiceRepository;
	
	HotelRepository hotelRepository;
	
	@Override
	public AdditionalService save(AdditionalService addService) {
		return additionalServiceRepository.save(addService);
	}

	@Override
	public ArrayList<AdditionalService> getAll() {
		List<AdditionalService> retVal = additionalServiceRepository.findAll();
		
		return (ArrayList<AdditionalService>) retVal;
	}

	@Override
	public AdditionalService findById(String id) {
		AdditionalService retVal;
		Optional<AdditionalService> byId = additionalServiceRepository.findById(id);
		retVal = byId.get();
		
		return retVal;
	}

	@Override
	public AdditionalService createAdditionalService(AdditionalService additionalService) {
		AdditionalService createdAdditionalServices = new AdditionalService();
		createdAdditionalServices.setService(additionalService.getService());
		createdAdditionalServices.setPrice(additionalService.getPrice());
		additionalServiceRepository.save(createdAdditionalServices);
		return createdAdditionalServices;
	}

	@Override
	public AdditionalService deleteAdditionalService(Long id) {
//		for (Hotel h : hotelRepository.findAll()) {
//			if (h.getAdditionalServices() != null) {
//				for (int i = 0; i < h.getAdditionalServices().size(); i++) {
//
//					if (h.getAdditionalServices().get(i).getId().equals(id)) {
//						h.getAdditionalServices().remove(i);
//						hotelRepository.save(h);
//					}
//
//				}
//			}
//		}

		AdditionalService deletedAdditionalServices = additionalServiceRepository.findById(id);
		additionalServiceRepository.delete(deletedAdditionalServices);

		return deletedAdditionalServices;
	}

	@Override
	public AdditionalService editAdditionalService(Long id, AdditionalService additionalService) {
		AdditionalService editedAddition = additionalServiceRepository.findById(id);
		editedAddition.setService(additionalService.getService());
		editedAddition.setPrice(additionalService.getPrice());
		additionalServiceRepository.save(editedAddition);
		
		return editedAddition;
	}

}
