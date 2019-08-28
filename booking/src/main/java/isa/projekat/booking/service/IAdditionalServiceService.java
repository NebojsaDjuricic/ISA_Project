package isa.projekat.booking.service;

import java.util.ArrayList;

import isa.projekat.booking.domain.AdditionalService;

public interface IAdditionalServiceService {
	
	AdditionalService save(AdditionalService addService);
	ArrayList<AdditionalService> getAll();
	AdditionalService findById(String id);
//	ArrayList<AdditionalService> createAdditionalService(AdditionalService additionalService);
//	ArrayList<AdditionalService> deleteAdditionalService(String id);
//	ArrayList<AdditionalService> editAdditionalService(String id, String service);
	AdditionalService createAdditionalService(AdditionalService additionalService);
	AdditionalService deleteAdditionalService(Long id);
	AdditionalService editAdditionalService(Long id, AdditionalService additionalService);
}
