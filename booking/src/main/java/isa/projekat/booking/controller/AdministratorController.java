package isa.projekat.booking.controller;

import isa.projekat.booking.domain.AdministatorType;
import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.domain.dto.AdministratorDTO;
import isa.projekat.booking.domain.dto.AdministratorFullDTO;
import isa.projekat.booking.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "*")
public class AdministratorController {

    @Autowired
    private IAdministratorService administratorService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> login(@RequestBody AdministratorDTO admin) {

        System.out.println("Login");

        Administrator fromDB = administratorService.findById(admin.getUsername());

        if(fromDB != null) {
            if(fromDB.getPassword().equals(admin.getPassword())) {
                String token = fromDB.getUsername()+"."+fromDB.getType()+"."+fromDB.getEditingObjectID();
                HashMap<String, Object> response = new HashMap<>();
                response.put("token", token);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
        else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> addNewAdmin(@RequestBody AdministratorFullDTO admin) {

        Administrator fromDB = administratorService.findById(admin.getUsername());

        if(fromDB == null) {
            Administrator newAdmin = new Administrator();
            newAdmin.setUsername(admin.getUsername());
            newAdmin.setPassword(admin.getPassword());
            newAdmin.setEmail(admin.getEmail());
            newAdmin.setEditingObjectID(admin.getEditingObjectID());

            switch(admin.getRole()) {
                case "SYSTEM_ADMIN":
                    newAdmin.setType(AdministatorType.SYSTEM_ADMIN);
                    break;
                case "AIRLINE_ADMIN" :
                    newAdmin.setType(AdministatorType.AIRLINE_ADMIN);
                    break;
                case "HOTEL_ADMIN":
                    newAdmin.setType(AdministatorType.HOTEL_ADMIN);
                    break;
                case "RENT_A_CAR_SERVICE_ADMIN":
                    newAdmin.setType(AdministatorType.RENT_A_CAR_SERVICE_ADMIN);
                    break;
            }

            administratorService.save(newAdmin);

            return  new ResponseEntity<>(newAdmin, HttpStatus.OK);
        }



        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/get/{adminID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getAdmin(@PathVariable("adminID")String adminID) {

        Administrator admin = administratorService.findById(adminID);

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

}
