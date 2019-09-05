package isa.projekat.booking.controller;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.domain.dto.VehicleDTO;
import isa.projekat.booking.domain.dto.VehicleSearchQuery;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IBranchService;
import isa.projekat.booking.service.IRentACarService;
import isa.projekat.booking.service.IVehicleReservationsService;
import isa.projekat.booking.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@RestController
@RequestMapping("vehicle")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private IBranchService branchService;

    @Autowired
    private IRentACarService rentACarService;

    @Autowired
    private IAdministratorService administratorService;
    
    @Autowired
    private IVehicleReservationsService vehicleReservationService;

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> addNewVehicle(@RequestBody VehicleDTO vehicle) {

        System.out.println(vehicle);

        Vehicle fromDB = vehicleService.findByID(vehicle.getLicenceID());

        if(fromDB == null) {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setStatus(VehicleStatus.IN_SERVICE);
            newVehicle.setRating(0.0);
            newVehicle.setPrice(vehicle.getPrice());
            newVehicle.setLicenceID(vehicle.getLicenceID());
            newVehicle.setModel(vehicle.getModel());
            newVehicle.setBrand(vehicle.getBrand());

            vehicleService.save(newVehicle);

            // Add to branch
            String branchID = vehicle.getBranchID();
            Branch branch = branchService.findByID(branchID);
            branch.getVehicles().add(newVehicle);

            branchService.save(branch);

            // Update Rent-A-Car Service
            String adminID = vehicle.getAdmin();
            Administrator admin = administratorService.findById(adminID);
            String rent_a_car_serviceID = admin.getEditingObjectID();
            RentACarService rent_a_car_service = rentACarService.findByID(rent_a_car_serviceID);
            ArrayList<Branch> branches = rent_a_car_service.getBranches();

            for(int i = 0; i < branches.size(); i++) {
                if(branches.get(i).getId().equals(branchID)) {
                    branches.get(i).getVehicles().add(newVehicle);
                    break;
                }
            }

            rent_a_car_service.setBranches(branches);

            rentACarService.save(rent_a_car_service);

            return  new ResponseEntity<>(newVehicle, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> saveVehicle(@RequestBody VehicleDTO vehicle) {

        Vehicle newVehicle = new Vehicle();
        newVehicle.setBrand(vehicle.getBrand());
        newVehicle.setModel(vehicle.getModel());
        newVehicle.setLicenceID(vehicle.getLicenceID());
        newVehicle.setPrice(vehicle.getPrice());
        newVehicle.setStatus(vehicle.getStatus());

        vehicleService.save(newVehicle);

        String branchID = vehicle.getBranchID();
        String adminID = vehicle.getAdmin();

        Branch branch = branchService.findByID(branchID);
        ArrayList<Vehicle> vehicles = branch.getVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getLicenceID().equals(newVehicle.getLicenceID())) {
                vehicles.get(i).setStatus(newVehicle.getStatus());
                vehicles.get(i).setPrice(newVehicle.getPrice());
                vehicles.get(i).setModel(newVehicle.getModel());
                vehicles.get(i).setBrand(newVehicle.getBrand());
                break;
            }
        }
        branch.setVehicles(vehicles);

        branchService.save(branch);

        Administrator admin = administratorService.findById(adminID);
        String rent_a_car_serviceID = admin.getEditingObjectID();
        RentACarService rent_a_car_service = rentACarService.findByID(rent_a_car_serviceID);
        ArrayList<Branch> branches = rent_a_car_service.getBranches();

        for(int i = 0; i < branches.size(); i++) {
            if(branches.get(i).getId().equals(branchID)) {
                branches.get(i).setVehicles(vehicles);
                break;
            }
        }

        rent_a_car_service.setBranches(branches);

        rentACarService.save(rent_a_car_service);

        return new ResponseEntity<>(newVehicle, HttpStatus.OK);
    }

    @RequestMapping(
            value="/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getVehicle(@PathVariable("id")String id){

        Vehicle vehicle = vehicleService.findByID(id);

        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> search(@RequestBody VehicleSearchQuery query) {

        //validate
    	LocalDate startDate = stringToDate(query.getStartDate());
    	LocalDate endDate = stringToDate(query.getEndDate());
    	List<Vehicle> vehiclesToShow = new ArrayList<Vehicle>();
    	Map<String, Vehicle> mapOfVehiclesToShow = new HashMap<String, Vehicle>();
    	List<Vehicle> returnValue = new ArrayList<Vehicle>();
    	
    	List<Vehicle> vehicles = vehicleService.findByVehicleTypeAndSeats(query.getType(), query.getPassengers());
    	
    	Map<String, List<VehicleReservation>> reservationsByVehicleID = new HashMap<String, List<VehicleReservation>>();
    	
    	if(vehicles.isEmpty()) {
    		
    	}
    	else {
    		for (Vehicle vehicle : vehicles) {
    			reservationsByVehicleID.put(
    					vehicle.getLicenceID(), 
    					vehicleReservationService.findByVehicleAndRentACarServiceID(vehicle.getLicenceID(), 
    							query.getRentACarServiceID()));
    		}
    	}
    	
    	Iterator<Entry<String, List<VehicleReservation>>> it = reservationsByVehicleID.entrySet().iterator();
    	while(it.hasNext()) {
    		Map.Entry<String, List<VehicleReservation>> pair = (Map.Entry<String, List<VehicleReservation>>)it.next();
    		
    		List<VehicleReservation> reservations = pair.getValue();
    		Boolean alreadyBooked = false;
    		
    		
    		//compare dates
    		
    		if(reservations.isEmpty()) {
    			
    		}
    		else {
    			for (VehicleReservation reservation : reservations) {
        			alreadyBooked = false;
    				if(startDate.isAfter(reservation.getStartDate())) {
    					if(startDate.isBefore(reservation.getEndDate())) {
    						alreadyBooked = true;
    						break;
    					}
    				}
    				
    				if(endDate.isAfter(reservation.getStartDate())) {
    					if(endDate.isBefore(reservation.getEndDate())) {
    						alreadyBooked = true;
    						break;
    					}
    				}
    				
    				if(startDate.isBefore(reservation.getStartDate())) {
    					if(endDate.isAfter(reservation.getEndDate())) {
    						alreadyBooked = true;
    						break;
    					}
    				}
    			}
    		}
    		
    		
    		
    		if(!alreadyBooked) {
				//vehiclesToShow.add(vehicleService.findByID(pair.getKey()));
				mapOfVehiclesToShow.put(pair.getKey(), vehicleService.findByID(pair.getKey()));
			}
    		
    		
    		it.remove();
    	}    	
    	
    	// Filter out vehicles on discount
    	RentACarService racs = rentACarService.findByID(query.getRentACarServiceID());
    	ArrayList<VehicleDiscount> vehiclesOnDiscount = racs.getVehiclesOnDiscount();
    	
    	for (VehicleDiscount discount : vehiclesOnDiscount) {
			if(mapOfVehiclesToShow.containsKey(discount.getVehicleID())) {
				mapOfVehiclesToShow.remove(discount.getVehicleID());
			}
		}
    	
    	for (Map.Entry<String, Vehicle> vehicle : mapOfVehiclesToShow.entrySet()) {
			returnValue.add(vehicle.getValue());
		}
    	

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/makeReservation",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> makeReservation() {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    public LocalDate stringToDate(String date) {
    	
    	String[] token = date.split("-");
    	
    	int year = 0;
    	int month = 0;
    	int dayOfMonth = 0;
    	
    	month = Integer.parseInt(token[1]);
    	dayOfMonth = Integer.parseInt(token[2]);
    	year = Integer.parseInt(token[0]);
    	
    	LocalDate result = LocalDate.of(year, month, dayOfMonth);
    	
    	return result;
    }

}
