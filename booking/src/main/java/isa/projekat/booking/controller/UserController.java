package isa.projekat.booking.controller;

import isa.projekat.booking.domain.User;
import isa.projekat.booking.domain.dto.UserDTO;
import isa.projekat.booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")

public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public void testMethod() {
        System.out.println("UserController testMethod. Success.");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST
    )
    public ResponseEntity<Object> login(@RequestBody UserDTO user) {
        if(user.getEmail() == null || user.getEmail().equals("")) {
            return new ResponseEntity<>("Enter username", HttpStatus.NOT_ACCEPTABLE);
        }

        User userFromDB = userService.findByEmail(user.getEmail());

        if(userFromDB != null) {
            if(userFromDB.getPassword().equals(user.getPassword())) {
                String token = userFromDB.getUsername();
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
}
