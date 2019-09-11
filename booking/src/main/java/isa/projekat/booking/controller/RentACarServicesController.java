package isa.projekat.booking.controller;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.domain.dto.AddressDTO;
import isa.projekat.booking.domain.dto.BranchDTO;
import isa.projekat.booking.domain.dto.BranchesAndVehiclesMapDTO;
import isa.projekat.booking.domain.dto.RentACarSearchQueryDTO;
import isa.projekat.booking.domain.dto.RentACarSearchResult;
import isa.projekat.booking.domain.dto.RentACarServiceDTO;
import isa.projekat.booking.domain.dto.VehicleDTO;
import isa.projekat.booking.domain.dto.VehicleDiscountDTO;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IBranchService;
import isa.projekat.booking.service.IRentACarService;
import isa.projekat.booking.service.IVehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rent-a-car")
@CrossOrigin(origins = "*")
public class RentACarServicesController {

    @Autowired
    private IRentACarService rentACarService;

    @Autowired
    private IBranchService branchService;

    @Autowired
    private IAdministratorService administratorService;
    
    @Autowired
    private IVehicleService vehicleService;


    @RequestMapping(
            value="/get-all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getAllRentACarServices() {
        ArrayList<RentACarService> data = rentACarService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @RequestMapping(
            value="/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getRentACarService(@PathVariable("id")String id ) {
        RentACarService fromDB = rentACarService.findByID(id);
        RentACarServiceDTO retVal = new RentACarServiceDTO();
        
        retVal.setDescription(fromDB.getDescription());
        retVal.setId(id);
        retVal.setName(fromDB.getName());
        retVal.setRating(fromDB.getRating());
        
        AddressDTO address = new AddressDTO();
        address.setBuildingNumber(fromDB.getAddress().getBuildingNumber());
        address.setCity(fromDB.getAddress().getCity());
        address.setCountry(fromDB.getAddress().getCountry());
        address.setStreetName(fromDB.getAddress().getStreetName());
        address.setCoordinatePosition(fromDB.getAddress().getCoordinatePosition());
        retVal.setAddress(address);
        
        ArrayList<BranchDTO> branches = new ArrayList<BranchDTO>();
        for (Branch dbBranch : fromDB.getBranches()) {
			BranchDTO branch = new BranchDTO();
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setBuildingNumber(dbBranch.getAddress().getBuildingNumber());
			addressDTO.setCity(dbBranch.getAddress().getCity());
			addressDTO.setCountry(dbBranch.getAddress().getCountry());
			addressDTO.setStreetName(dbBranch.getAddress().getStreetName());
			address.setCoordinatePosition(dbBranch.getAddress().getCoordinatePosition());
			branch.setAddress(addressDTO);
			
			ArrayList<Administrator> admins = administratorService.getAll();
			for (Administrator admin : admins) {
				if(id.equals(admin.getEditingObjectID())) {
					branch.setAdmin(admin.getUsername());
					break;
				}
			}
			branch.setContactEmail(dbBranch.getContactEmail());
			branch.setId(dbBranch.getId());
			branch.setName(dbBranch.getName());
			branch.setPhoneNumber(dbBranch.getPhoneNumber());

			ArrayList<VehicleDTO> listOfVehicles = new ArrayList<VehicleDTO>();
			ArrayList<Vehicle> vehicles = dbBranch.getVehicles();
			for (Vehicle vehicle : vehicles) {
				VehicleDTO vehicleDTO = new VehicleDTO();
				vehicleDTO.setAdmin(branch.getAdmin());
				vehicleDTO.setBranchID(branch.getId());
				vehicleDTO.setBrand(vehicle.getBrand());
				vehicleDTO.setLicenceID(vehicle.getLicenceID());
				vehicleDTO.setManufacturingYear(vehicle.getManufacturingYear());
				vehicleDTO.setModel(vehicle.getModel());
				vehicleDTO.setName(vehicle.getName());
				vehicleDTO.setNumberOfSeats(vehicle.getNumberOfSeats());
				vehicleDTO.setPrice(vehicle.getPrice());
				vehicleDTO.setRating(vehicle.getRating());
				vehicleDTO.setStatus(vehicle.getStatus());
				vehicleDTO.setVehicleType(vehicle.getVehicleType());
				listOfVehicles.add(vehicleDTO);
			}
			branch.setVehicles(listOfVehicles);
		}

        return  new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @RequestMapping(
            value="/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> addRentACarService(@RequestBody RentACarServiceDTO rent_a_car) {

        System.out.println(rent_a_car);

        RentACarService newRentACar = new RentACarService();
        newRentACar.setId(rent_a_car.getName()+ Calendar.getInstance().getTimeInMillis());
        newRentACar.setRating(0.0);
        newRentACar.setName(rent_a_car.getName());
        newRentACar.setDescription(rent_a_car.getDescription());
        newRentACar.setBranches(new ArrayList<>());
        Address address = new Address();
        address.setStreetName(rent_a_car.getAddress().getStreetName());
        address.setBuildingNumber(rent_a_car.getAddress().getBuildingNumber());
        address.setCity(rent_a_car.getAddress().getCity());
        address.setCountry(rent_a_car.getAddress().getCountry());
        newRentACar.setAddress(address);

        rentACarService.save(newRentACar);

        return new ResponseEntity<>(newRentACar, HttpStatus.OK);
    }
    
    @RequestMapping(
    		value = "/edit-rent-a-car",
    		method = RequestMethod.PUT,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editRentACarService(@RequestBody RentACarServiceDTO rent_a_car) {
    	
    	RentACarService updatedRentACarService = new RentACarService();
    	Address newAddress = new Address();
    	newAddress.setBuildingNumber(rent_a_car.getAddress().getBuildingNumber());
    	newAddress.setCity(rent_a_car.getAddress().getCity());
    	newAddress.setCoordinatePosition(rent_a_car.getAddress().getCoordinatePosition());
    	newAddress.setCountry(rent_a_car.getAddress().getCountry());
    	newAddress.setStreetName(rent_a_car.getAddress().getStreetName());
    	updatedRentACarService.setAddress(newAddress);
    	
    	ArrayList<Branch> newBranches = new ArrayList<Branch>();
    	for (BranchDTO branch : rent_a_car.getBranches()) {
			Branch newBranch = new Branch();
			newBranch.setContactEmail(branch.getContactEmail());
			newBranch.setId(branch.getId());
			newBranch.setName(branch.getName());
			newBranch.setPhoneNumber(branch.getPhoneNumber());
			//address
			Address tempAddress = new Address();
			tempAddress.setBuildingNumber(branch.getAddress().getBuildingNumber());
			tempAddress.setCity(branch.getAddress().getCity());
			tempAddress.setCoordinatePosition(branch.getAddress().getCoordinatePosition());
			tempAddress.setCountry(branch.getAddress().getCountry());
			tempAddress.setStreetName(branch.getAddress().getStreetName());
			newBranch.setAddress(newAddress);
			//veh
			ArrayList<Vehicle> newVehicleList = new ArrayList<Vehicle>();
			for (VehicleDTO vehicle : branch.getVehicles()) {
				newVehicleList.add(vehicleService.findByID(vehicle.getLicenceID()));
			}
			newBranch.setVehicles(newVehicleList);
			
		}
    	updatedRentACarService.setBranches(newBranches);
    	
    	Map<String, List<String>> mapa = new HashMap<String, List<String>>();
    	ArrayList<BranchesAndVehiclesMapDTO> tempLikeMap = rent_a_car.getBranchesAndVehicles();
    	for (BranchesAndVehiclesMapDTO temp : tempLikeMap) {
			ArrayList<String> vehicleIDs = new ArrayList<String>();
			for (String id : temp.getVehiclesInBranch()) {
				vehicleIDs.add(id);
			}
			mapa.put(temp.getBranchID(), vehicleIDs);
		}
    	updatedRentACarService.setBranchesAndVehicles(mapa);
    	
    	updatedRentACarService.setDescription(rent_a_car.getDescription());
    	
    	updatedRentACarService.setId(rent_a_car.getId());
    	
    	updatedRentACarService.setName(rent_a_car.getName());
    	
    	updatedRentACarService.setRating(rentACarService.findByID(rent_a_car.getId()).getRating());
    	
    	Map<String, String> vehicleIDMap = new HashMap<String, String>();
    	for (String id : rent_a_car.getVehicles()) {
			vehicleIDMap.put(id, id);
		}
    	updatedRentACarService.setVehicles(vehicleIDMap);
    	
    	//vehiclesOnDiscount
    	ArrayList<VehicleDiscount> discountList = new ArrayList<VehicleDiscount>();
    	for (VehicleDiscountDTO discountDTO : rent_a_car.getVehiclesOnDiscount()) {
			VehicleDiscount newDiscount = new VehicleDiscount();
			newDiscount.setDiscount(discountDTO.getDiscount());
			newDiscount.setId(discountDTO.getId());
			newDiscount.setVehicleID(discountDTO.getVehicleID());
			newDiscount.setDiscountStartDate(stringToDate(discountDTO.getDiscountStartDate()));
			newDiscount.setDiscountEndDate(stringToDate(discountDTO.getDiscountEndDate()));
			discountList.add(newDiscount);
    	}
    	updatedRentACarService.setVehiclesOnDiscount(discountList);
    	
    	rentACarService.save(updatedRentACarService);    	
    	
    	return new ResponseEntity<>("", HttpStatus.OK);
    }
    

    @RequestMapping(
            value="/add-branch",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> addNewBranch(@RequestBody BranchDTO branch) {

        System.out.println(branch);

        Branch newBranch = new Branch();
        newBranch.setVehicles(new ArrayList<>());
        newBranch.setId(branch.getName()+Calendar.getInstance().getTimeInMillis());
        newBranch.setPhoneNumber(branch.getPhoneNumber());
        newBranch.setName(branch.getName());
        newBranch.setContactEmail(branch.getContactEmail());
        Address address = new Address();
        address.setBuildingNumber(branch.getAddress().getBuildingNumber());
        address.setCity(branch.getAddress().getCity());
        address.setCountry(branch.getAddress().getCountry());
        address.setStreetName(branch.getAddress().getStreetName());
        address.setCoordinatePosition(branch.getAddress().getCoordinatePosition());
        newBranch.setAddress(address);

        branchService.save(newBranch);

        // Add branch to Rent-a-car service
        String adminID = branch.getAdmin();
        Administrator admin = administratorService.findById(adminID);
        String rent_a_car_serviceID = admin.getEditingObjectID();

        RentACarService rent_a_car_service = rentACarService.findByID(rent_a_car_serviceID);
        rent_a_car_service.getBranches().add(newBranch);

        rentACarService.save(rent_a_car_service);

        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @RequestMapping(
            value="/branches/{adminID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getBranches(@PathVariable("adminID")String adminID) {

        System.out.println("AdminID: " + adminID);

        Administrator admin = administratorService.findById(adminID);
        String rent_a_car_serviceID = admin.getEditingObjectID();

        RentACarService rent_a_car_service = rentACarService.findByID(rent_a_car_serviceID);

        ArrayList<Branch> branches = rent_a_car_service.getBranches();

        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
    
    
    //search racs
    @RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> search(@RequestBody String query) {
    	
    	System.out.println("Query input: " + query);
    	
    	//List<RentACarService> retVal = rentACarService.findByName(query.getQueryInput());
    	List<RentACarService> retVal = rentACarService.findByName(query);

    	RentACarSearchResult result = new RentACarSearchResult();
    	result.setQueryResult(retVal);
    	
    	return new ResponseEntity<>(result, HttpStatus.OK);
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
