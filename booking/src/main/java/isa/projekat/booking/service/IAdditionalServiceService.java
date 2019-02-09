package isa.projekat.booking.service;

import java.util.ArrayList;

import isa.projekat.booking.domain.AdditionalService;

public interface IAdditionalServiceService {
	
	AdditionalService save(AdditionalService addService);
	ArrayList<AdditionalService> getAll();
	AdditionalService findById(String id);
}
