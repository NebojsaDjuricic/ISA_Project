package isa.projekat.booking.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.projekat.booking.domain.AdditionalService;
import isa.projekat.booking.service.IAdditionalServiceService;

@RestController
@RequestMapping("additionalServices")
@CrossOrigin(origins = "*")
public class AdditionalServiceController {
	
	@Autowired
	private IAdditionalServiceService additionalServicesService;

	
	//  value = "/{hotelId}/services/{id}"
	// Vraca dodatnu uslugu
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AdditionalService> getAdditionalService(@PathVariable String id) {
	System.out.println("\n GET ADDITIONAL SERVICE:  " + id + "\n");
	AdditionalService additionalService = additionalServicesService.findById(id);
	
	if (additionalService != null) {
		return new ResponseEntity<AdditionalService>(additionalService, HttpStatus.OK);
	}
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// value = "/{hotelId}/additionalServices
	// Vraca dodatne usluge
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<AdditionalService>> getAdditionalServices() {
	System.out.println("\n GET ADDITIONAL SERVICES TYPES " + "\n");
	ArrayList<AdditionalService> additionalServices = (ArrayList<AdditionalService>) additionalServicesService.getAll();
	
	if (additionalServices != null) {
		return new ResponseEntity<Collection<AdditionalService>>(additionalServices, HttpStatus.OK);
	}
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// Kreira uslugu
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<AdditionalService> createAdditionalService(@RequestBody AdditionalService additionalService) {
	System.out.println("\n CREATE ACCOMMODATION TYPE " + "\n");
	
	AdditionalService createdAdditionalService = additionalServicesService.createAdditionalService(additionalService);
	
	if (createdAdditionalService != null) {
		return new ResponseEntity<AdditionalService>(createdAdditionalService, HttpStatus.OK);
	}
	
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	// Brise uslugu
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<AdditionalService> deleteAdditionalService(@PathVariable Long id) {
	System.out.println("\n DELETE ADDITIONAL SERVICE WITH ID:  " + id + "\n");
	AdditionalService  deletedAdditionalService = additionalServicesService.deleteAdditionalService(id);
	
	if (deletedAdditionalService != null) {
		return new ResponseEntity<AdditionalService>(deletedAdditionalService, HttpStatus.OK);
	}
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// Izmena usluge
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<AdditionalService> editAdditionalService(@PathVariable Long id, @RequestBody AdditionalService service) {
	System.out.println("\n EDIT ADDITIONAL SERVICE:  " + id + "\n");
	AdditionalService editedAdditionalService = additionalServicesService.editAdditionalService(id, service);
	
	if (editedAdditionalService != null) {
		return new ResponseEntity<AdditionalService>(editedAdditionalService, HttpStatus.OK);
	}
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
