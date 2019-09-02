package isa.projekat.booking.controller;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.domain.dto.VehicleDTO;
import isa.projekat.booking.domain.dto.VehicleSearchQuery;
import isa.projekat.booking.service.IAdministratorService;
import isa.projekat.booking.service.IBranchService;
import isa.projekat.booking.service.IRentACarService;
import isa.projekat.booking.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println(query.toString());
        
        List<Vehicle> queryResult = vehicleService.findByVehicleType(query.getType());
        
        for (Vehicle vehicle : queryResult) {
			System.out.println(vehicle.getLicenceID());
		}

        return new ResponseEntity<>(null, HttpStatus.OK);
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

}
