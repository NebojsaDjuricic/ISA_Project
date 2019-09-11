package isa.projekat.booking.controller;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.domain.dto.BranchDTO;
import isa.projekat.booking.domain.dto.RentACarSearchQueryDTO;
import isa.projekat.booking.domain.dto.RentACarSearchResult;
import isa.projekat.booking.domain.dto.RentACarServiceDTO;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IBranchService;
import isa.projekat.booking.service.IRentACarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        RentACarService retVal = rentACarService.findByID(id);

        //System.out.println(retVal.getBranches().get(0).getVehicles().get(0).getStatus());

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
    		value = "/edit-branch",
    		method = RequestMethod.PUT,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editRentACarService(@RequestBody RentACarServiceDTO rent_a_car) {
    	
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
        newBranch.setAddress(branch.getAddress());

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

}
