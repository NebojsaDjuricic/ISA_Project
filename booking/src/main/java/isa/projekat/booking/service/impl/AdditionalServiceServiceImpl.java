package isa.projekat.booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import isa.projekat.booking.domain.AdditionalService;
import isa.projekat.booking.repository.AdditionalServiceRepository;
import isa.projekat.booking.service.IAdditionalServiceService;

public class AdditionalServiceServiceImpl implements IAdditionalServiceService{

	@Autowired
	AdditionalServiceRepository additionalServiceRepository;
	
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

}
