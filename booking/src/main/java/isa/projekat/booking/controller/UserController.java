package isa.projekat.booking.controller;

import isa.projekat.booking.domain.User;
import isa.projekat.booking.domain.dto.UserDTO;
import isa.projekat.booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
    	
    	sendEmail(user.getEmail());
    	
    	User newUser = new User();
    	newUser.setActiveAccount(false);
    	newUser.setAddress(user.getAddress());
    	newUser.setEmail(user.getEmail());
    	newUser.setFirstName(user.getFirstName());
    	newUser.setLastName(user.getLastName());
    	newUser.setPassword(user.getPassword());
    	newUser.setPhoneNumber(user.getPhoneNumber());
    	newUser.setPoints(0.0);
    	newUser.setUsername(user.getEmail());
    	
        userService.save(newUser);
    }
    
    @RequestMapping(
    		value="/activate/{email}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> activateAccount(@PathVariable("email")String email) {
    	
    	User user = userService.findByEmail(email);
    	user.setActiveAccount(true);
    	
    	userService.save(user);
    	
    	return new ResponseEntity<Object>(HttpStatus.OK);
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
    
    
    
    
    void sendEmail(String userEmail) {
    	
    	final String username = "ftn.isa.projekat@gmail.com";
        final String password = "javamail2019";
        
        Properties prop = new Properties();
    	
    	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply-isa@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(userEmail)
            );
            message.setSubject("Testing Gmail TLS");
            
            String activationURL = "http://localhost:8080/user/activate/" + userEmail;
            
            message.setText("<a href=\"" + activationURL + "\">Activate your account</a>", "UTF-8", "html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
}
