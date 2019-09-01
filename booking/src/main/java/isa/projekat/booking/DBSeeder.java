package isa.projekat.booking;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Component
public class DBSeeder implements CommandLineRunner {

    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AdditionalServiceRepository additionalServiceRepository;

    @Autowired
    private AdministratorRepository administratorRepository;
    
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        
        roomRepository.deleteAll();
        hotelRepository.deleteAll();
        additionalServiceRepository.deleteAll();
        administratorRepository.deleteAll();
        priceRepository.deleteAll();

        //---------------- USERS ----------------//

        User user1 = new User();
        user1.setActiveAccount(true);
        user1.setAddress("Slobodana Bajica 1, Novi Sad");
        user1.setEmail("bobanpoznanovic1@gmail.com");
        user1.setFirstName("Boban");
        user1.setLastName("Poznanovic");
        user1.setPassword("mojasifra");
        user1.setPhoneNumber("+381 63 17 38 959");
        user1.setPoints(0.0);
        user1.setUsername("BobanNS");

        User user2 = new User();
        user2.setActiveAccount(true);
        user2.setAddress("Ulica 143, Novi Sad");
        user2.setEmail("neba@gmail.com");
        user2.setFirstName("Nebojsa");
        user2.setLastName("Djuricic");
        user2.setPassword("random");
        user2.setPhoneNumber("+381601234567");
        user2.setPoints(0.0);
        user2.setUsername("Neba");
        
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        
        userRepository.saveAll(users);

        

        //-------------- ADDITIONAL SERVICES --------------//

        AdditionalService addService1 = new AdditionalService();
        addService1.setId((long) 1);
        addService1.setService("WIFI");

        AdditionalService addService2 = new AdditionalService();
        addService2.setId((long) 2);
        addService2.setService("PARKING");

        AdditionalService addService3 = new AdditionalService();
        addService3.setId((long) 3);
        addService3.setService("AIRPORT TRANSFER");

        AdditionalService addService4 = new AdditionalService();
        addService4.setId((long) 4);
        addService4.setService("ROOM SERVICE");

        AdditionalService addService5 = new AdditionalService();
        addService5.setId((long) 5);
        addService5.setService("MINI BAR");

        AdditionalService addService6 = new AdditionalService();
        addService6.setId((long) 6);
        addService6.setService("KITCHEN");

        AdditionalService addService7 = new AdditionalService();
        addService7.setId((long) 7);
        addService7.setService("TV");

        AdditionalService addService8 = new AdditionalService();
        addService8.setId((long) 8);
        addService8.setService("AIR CONDITION");

        AdditionalService addService9 = new AdditionalService();
        addService9.setId((long) 9);
        addService9.setService("BREAKFAST");

        AdditionalService addService10 = new AdditionalService();
        addService10.setId((long) 10);
        addService10.setService("HALF BOARD");

        AdditionalService addService11 = new AdditionalService();
        addService11.setId((long) 11);
        addService11.setService("FULL BOARD");

        AdditionalService addService12 = new AdditionalService();
        addService12.setId((long) 12);
        addService12.setService("PRIVATE BATHROOM");

        AdditionalService addService13 = new AdditionalService();
        addService13.setId((long) 13);
        addService13.setService("SWIMMING POOL");

        AdditionalService addService14 = new AdditionalService();
        addService14.setId((long) 14);
        addService14.setService("WELLNESS");

        AdditionalService addService15 = new AdditionalService();
        addService15.setId((long) 15);
        addService15.setService("TENNIS COURTS");

        AdditionalService addService16 = new AdditionalService();
        addService16.setId((long) 16);
        addService16.setService("BOWLING HALL");

        AdditionalService addService17 = new AdditionalService();
        addService17.setId((long) 17);
        addService17.setService("GYM");

        AdditionalService addService18 = new AdditionalService();
        addService18.setId((long) 18);
        addService18.setService("SOLARIUM");
        
        AdditionalService addService19 = new AdditionalService();
        addService19.setId((long) 19);
        addService19.setService("EXTRA BED");

        // ADDING ADDITIONAL SERVICES TO DB

        ArrayList<AdditionalService> additionalServices = new ArrayList<>();
        additionalServices.add(addService1); additionalServices.add(addService2); additionalServices.add(addService3); additionalServices.add(addService4);
        additionalServices.add(addService5); additionalServices.add(addService6); additionalServices.add(addService7); additionalServices.add(addService8);
        additionalServices.add(addService9); additionalServices.add(addService10); additionalServices.add(addService11); additionalServices.add(addService12);
        additionalServices.add(addService13); additionalServices.add(addService14); additionalServices.add(addService15); additionalServices.add(addService16);
        additionalServices.add(addService17); additionalServices.add(addService18); additionalServices.add(addService19);

        additionalServiceRepository.saveAll(additionalServices);
        
        
        //------------------ PRICES ------------------//
        
// felix prices
        // room1
        Price price1 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price2 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price3 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price4 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room1
        
        // room3
        Price price5 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price6 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price7 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price8 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room3
        
        // room5
        Price price9 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price10 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price11 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price12 = new Price("felix_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room5
        
// end felix prices
        
// top prices
        // room2
        Price price13 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		22, false, 0.0);
        Price price14 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, true, 10.0);
        Price price15 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		23, false, 0.0);
        Price price16 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		25, false, 0.0);
        // end room2
        
        // room4
        Price price17 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		22, false, 0.0);
        Price price18 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, true, 10.0);
        Price price19 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		23, false, 0.0);
        Price price20 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		25, false, 0.0);
        // end room4
        
        // room6
        Price price21 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		22, false, 0.0);
        Price price22 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, true, 10.0);
        Price price23 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		23, false, 0.0);
        Price price24 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		25, false, 0.0);
        // end room6
        
        // room7
        Price price25 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		22, false, 0.0);
        Price price26 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, true, 10.0);
        Price price27 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		23, false, 0.0);
        Price price28 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		25, false, 0.0);
        // end room7
        
        // room8
        Price price29 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		22, false, 0.0);
        Price price30 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, true, 10.0);
        Price price31 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		23, false, 0.0);
        Price price32 = new Price("top_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		25, false, 0.0);
        // end room8
// end top prices
        
// samba prices
        // room9
        Price price33 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price34 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price35 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price36 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room9
        
        // room10
        Price price37 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price38 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price39 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price40 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room10
        
        // room11
        Price price41 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price42 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price43 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price44 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room11
        
        // room12
        Price price45 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price46 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price47 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price48 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room12
        
        // room13
        Price price49 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price50 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price51 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price52 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room13
        
        // room14
        Price price53 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price54 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price55 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price56 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room14
        
        // room15
        Price price57 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price58 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price59 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price60 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room15
        
        // room16
        Price price61 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		20, false, 0.0);
        Price price62 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		21, false, 0.0);
        Price price63 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price64 = new Price("samba_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room16
        
// end samba prices
        
// laurence prices
        // room17
        Price price65 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price66 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price67 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price68 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room17
        
        // room18
        Price price69 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price70 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price71 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price72 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room18
        
        // room19
        Price price73 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price74 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price75 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price76 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room19
        
        // room20
        Price price77 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price78 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price79 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price80 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room20
        
        // room21
        Price price81 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price82 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price83 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price84 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room21
        
        // room22
        Price price85 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price86 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price87 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price88 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room22
        
        // room23
        Price price89 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price90 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price91 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price92 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room23
        
        // room24
        Price price93 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price94 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price95 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price96 = new Price("laurence_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room24
        
// end laurence prices
        
// ripamonti prices
        // room25
        Price price97 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price98 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price99 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price100 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room 25
        
        // room26
        Price price101 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price102 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price103 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price104 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room 26
        
        // room27
        Price price105 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price106 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price107 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price108 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room 27
        
        // room28
        Price price109 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price110 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price111 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price112 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room 28
        
        // room29
        Price price113 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price114 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price115 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price116 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room 29
        
        // room30
        Price price117 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price118 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price119 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price120 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room 30
        
        // room31
        Price price121 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price122 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price123 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price124 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room31
        
        // room32
        Price price125 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price126 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price127 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price128 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room32
        
        // room33
        Price price129 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price130 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price131 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price132 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room33
        
        // room34
        Price price133 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price134 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price135 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price136 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room34
        
        // room35
        Price price137 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price138 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price139 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price140 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room35
        
        // room36
        Price price141 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price142 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price143 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price144 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room36
        
        // room37
        Price price145 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price146 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price147 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price148 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room37
        
        // room38
        Price price149 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price150 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price151 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price152 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room38
        
        // room39
        Price price153 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price154 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price155 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price156 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room39
        
        // room40
        Price price157 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price158 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price159 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price160 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room40
        
        // room41
        Price price161 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price162 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price163 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price164 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room41
        
        // room42
        Price price165 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price166 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price167 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price168 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room42
        
        // room43
        Price price169 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price170 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price171 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price172 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room43
        
        // room44
        Price price173 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price174 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price175 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price176 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room44
        
        // room45
        Price price177 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price178 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price179 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price180 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room45
        
        // room46
        Price price181 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), 
        		18, false, 0.0);
        Price price182 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31), 
        		17, false, 0.0);
        Price price183 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30), 
        		18, false, 0.0);
        Price price184 = new Price("ripamonti_" + 
        		UUID.randomUUID().toString().substring(0, 7), 
        		LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31), 
        		21, true, 5.0);
        // end room46
        
// end ripamonti prices
        
        ArrayList<Price> prices = new ArrayList<>();
        prices.add(price1); prices.add(price2); prices.add(price3); prices.add(price4); prices.add(price5); prices.add(price6);
        prices.add(price7); prices.add(price8); prices.add(price9); prices.add(price10); prices.add(price11); prices.add(price12);
        prices.add(price13); prices.add(price14); prices.add(price15); prices.add(price16); prices.add(price17); prices.add(price18);
        
        prices.add(price19); prices.add(price20); prices.add(price21); prices.add(price22); prices.add(price23); prices.add(price24);
        prices.add(price25); prices.add(price26); prices.add(price27); prices.add(price28); prices.add(price29); prices.add(price30);
        prices.add(price31); prices.add(price32); prices.add(price33); prices.add(price34); prices.add(price35); prices.add(price36);
        
        prices.add(price37); prices.add(price38); prices.add(price39); prices.add(price40); prices.add(price41); prices.add(price42);
        prices.add(price43); prices.add(price44); prices.add(price45); prices.add(price46); prices.add(price47); prices.add(price48);
        prices.add(price49); prices.add(price50); prices.add(price51); prices.add(price52); prices.add(price53); prices.add(price54);
        
        prices.add(price55); prices.add(price56); prices.add(price57); prices.add(price58); prices.add(price59); prices.add(price60);
        prices.add(price61); prices.add(price62); prices.add(price63); prices.add(price64); prices.add(price65); prices.add(price66);
        prices.add(price67); prices.add(price68); prices.add(price69); prices.add(price70); prices.add(price71); prices.add(price72);
        
        prices.add(price73); prices.add(price74); prices.add(price75); prices.add(price76); prices.add(price77); prices.add(price78);
        prices.add(price79); prices.add(price80); prices.add(price81); prices.add(price82); prices.add(price83); prices.add(price84);
        prices.add(price85); prices.add(price86); prices.add(price87); prices.add(price88); prices.add(price89); prices.add(price90);
        
        prices.add(price91); prices.add(price92); prices.add(price93); prices.add(price94); prices.add(price95); prices.add(price96);
        prices.add(price97); prices.add(price98); prices.add(price99); prices.add(price100); prices.add(price101); prices.add(price102);
        prices.add(price103); prices.add(price104); prices.add(price105); prices.add(price106); prices.add(price107); prices.add(price108);
        
        prices.add(price109); prices.add(price110); prices.add(price111); prices.add(price112); prices.add(price113); prices.add(price114);
        prices.add(price115); prices.add(price116); prices.add(price117); prices.add(price118); prices.add(price119); prices.add(price120);
        prices.add(price121); prices.add(price122); prices.add(price123); prices.add(price124); prices.add(price125); prices.add(price126);
        
        prices.add(price127); prices.add(price128); prices.add(price129); prices.add(price130); prices.add(price131); prices.add(price132);
        prices.add(price133); prices.add(price134); prices.add(price135); prices.add(price136); prices.add(price137); prices.add(price138);
        prices.add(price139); prices.add(price140); prices.add(price141); prices.add(price142); prices.add(price143); prices.add(price144);
        
        prices.add(price145); prices.add(price146); prices.add(price147); prices.add(price148); prices.add(price149); prices.add(price150);
        prices.add(price151); prices.add(price152); prices.add(price153); prices.add(price154); prices.add(price155); prices.add(price156);
        prices.add(price157); prices.add(price158); prices.add(price159); prices.add(price160); prices.add(price161); prices.add(price162);
        
        prices.add(price163); prices.add(price164); prices.add(price165); prices.add(price166); prices.add(price167); prices.add(price168);
        prices.add(price169); prices.add(price170); prices.add(price171); prices.add(price172); prices.add(price173); prices.add(price174);
        prices.add(price175); prices.add(price176); prices.add(price177); prices.add(price178); prices.add(price179); prices.add(price180);
        
        prices.add(price181); prices.add(price182); prices.add(price183); prices.add(price184);
        
        priceRepository.saveAll(prices);
        

        //------------------ ROOMS ------------------//

// felix
        Room room1 = new Room();
        room1.setId("felix.1101");
        room1.setStatus(RoomStatus.AVAILABLE);
        room1.setType(RoomType.SINGLE);
        room1.setCapacity(1);
        room1.setFloor(1);
        ArrayList<Price> roomPrices1 = new ArrayList<>();
        roomPrices1.add(price1);
        roomPrices1.add(price2);
        roomPrices1.add(price3);
        roomPrices1.add(price4);
        room1.setPrices(roomPrices1);
        room1.setRating(0.0);

        Room room3 = new Room();
        room3.setId("felix.2201");
        room3.setStatus(RoomStatus.AVAILABLE);
        room3.setType(RoomType.DOUBLE);
        room3.setCapacity(2);
        room3.setFloor(2);
        ArrayList<Price> roomPrices3 = new ArrayList<>();
        roomPrices3.add(price5);
        roomPrices3.add(price6);
        roomPrices3.add(price7);
        roomPrices3.add(price8);
        room3.setPrices(roomPrices3);
        room3.setRating(0.0);
        
        Room room5 = new Room();
        room5.setId("felix.3301");
        room5.setStatus(RoomStatus.AVAILABLE);
        room5.setType(RoomType.TRIPLE);
        room5.setCapacity(3);
        ArrayList<Price> roomPrices5 = new ArrayList<>();
        roomPrices5.add(price9);
        roomPrices5.add(price10);
        roomPrices5.add(price11);
        roomPrices5.add(price12);
        room5.setPrices(roomPrices5);
        room5.setFloor(3);
        room5.setRating(0.0);
// end felix
        
// top
        Room room2 = new Room();
        room2.setId("top.1101");
        room2.setStatus(RoomStatus.AVAILABLE);
        room2.setType(RoomType.SINGLE);
        room2.setCapacity(1);
        ArrayList<Price> roomPrices2 = new ArrayList<>();
        roomPrices2.add(price13);
        roomPrices2.add(price14);
        roomPrices2.add(price15);
        roomPrices2.add(price16);
        room2.setPrices(roomPrices2);
        room2.setFloor(1);
        room2.setRating(0.0);

        Room room4 = new Room();
        room4.setId("top.2201");
        room4.setStatus(RoomStatus.AVAILABLE);
        room4.setType(RoomType.DOUBLE);
        room4.setCapacity(2);
        ArrayList<Price> roomPrices4 = new ArrayList<>();
        roomPrices4.add(price17);
        roomPrices4.add(price18);
        roomPrices4.add(price19);
        roomPrices4.add(price20);
        room4.setPrices(roomPrices4);
        room4.setFloor(2);
        room4.setRating(0.0);   

        Room room6 = new Room();
        room6.setId("top.3301");
        room6.setStatus(RoomStatus.AVAILABLE);
        room6.setType(RoomType.TRIPLE);
        room6.setCapacity(3);
        ArrayList<Price> roomPrices6 = new ArrayList<>();
        roomPrices6.add(price21);
        roomPrices6.add(price22);
        roomPrices6.add(price24);
        roomPrices6.add(price24);
        room6.setPrices(roomPrices6);
        room6.setFloor(3);
        room6.setRating(0.0);

        Room room7 = new Room();
        room7.setId("top.4401");
        room7.setStatus(RoomStatus.AVAILABLE);
        room7.setType(RoomType.QUAD);
        room7.setCapacity(4);
        ArrayList<Price> roomPrices7 = new ArrayList<>();
        roomPrices7.add(price25);
        roomPrices7.add(price26);
        roomPrices7.add(price27);
        roomPrices7.add(price28);
        room7.setPrices(roomPrices7);
        room7.setFloor(4);
        room7.setRating(0.0);

        Room room8 = new Room();
        room8.setId("top.4402");
        room8.setStatus(RoomStatus.AVAILABLE);
        room8.setType(RoomType.QUAD);
        room8.setCapacity(4);
        ArrayList<Price> roomPrices8 = new ArrayList<>();
        roomPrices8.add(price29);
        roomPrices8.add(price30);
        roomPrices8.add(price31);
        roomPrices8.add(price32);
        room8.setPrices(roomPrices8);
        room8.setFloor(4);
        room8.setRating(0.0);
        
// end top
        
// samba
        Room room9 = new Room();
        room9.setId("samba.1101");
        room9.setStatus(RoomStatus.AVAILABLE);
        room9.setType(RoomType.SINGLE);
        room9.setCapacity(1);
        room9.setFloor(1);
        ArrayList<Price> roomPrices9 = new ArrayList<>();
        roomPrices9.add(price33);
        roomPrices9.add(price34);
        roomPrices9.add(price35);
        roomPrices9.add(price36);
        room9.setPrices(roomPrices9);
        room9.setRating(0.0);

        Room room10 = new Room();
        room10.setId("samba.1102");
        room10.setStatus(RoomStatus.AVAILABLE);
        room10.setType(RoomType.SINGLE);
        room10.setCapacity(1);
        ArrayList<Price> roomPrices10 = new ArrayList<>();
        roomPrices10.add(price37);
        roomPrices10.add(price38);
        roomPrices10.add(price39);
        roomPrices10.add(price40);
        room10.setPrices(roomPrices10);
        room10.setFloor(1);
        room10.setRating(0.0);

        Room room11 = new Room();
        room11.setId("samba.2201");
        room11.setStatus(RoomStatus.AVAILABLE);
        room11.setType(RoomType.DOUBLE);
        room11.setCapacity(2);
        ArrayList<Price> roomPrices11 = new ArrayList<>();
        roomPrices11.add(price41);
        roomPrices11.add(price42);
        roomPrices11.add(price43);
        roomPrices11.add(price44);
        room11.setPrices(roomPrices11);
        room11.setFloor(2);
        room11.setRating(0.0);

        Room room12 = new Room();
        room12.setId("samba.2202");
        room12.setStatus(RoomStatus.AVAILABLE);
        room12.setType(RoomType.DOUBLE);
        room12.setCapacity(2);
        ArrayList<Price> roomPrices12 = new ArrayList<>();
        roomPrices12.add(price45);
        roomPrices12.add(price46);
        roomPrices12.add(price47);
        roomPrices12.add(price48);
        room12.setPrices(roomPrices12);
        room12.setFloor(2);
        room12.setRating(0.0);

        Room room13 = new Room();
        room13.setId("samba.3301");
        room13.setStatus(RoomStatus.AVAILABLE);
        room13.setType(RoomType.TRIPLE);
        room13.setCapacity(3);
        ArrayList<Price> roomPrices13 = new ArrayList<>();
        roomPrices13.add(price49);
        roomPrices13.add(price50);
        roomPrices13.add(price51);
        roomPrices13.add(price52);
        room13.setPrices(roomPrices13);
        room13.setFloor(3);
        room13.setRating(0.0);

        Room room14 = new Room();
        room14.setId("samba.3302");
        room14.setStatus(RoomStatus.AVAILABLE);
        room14.setType(RoomType.TRIPLE);
        room14.setCapacity(3);
        ArrayList<Price> roomPrices14 = new ArrayList<>();
        roomPrices14.add(price53);
        roomPrices14.add(price54);
        roomPrices14.add(price55);
        roomPrices14.add(price56);
        room14.setPrices(roomPrices14);
        room14.setFloor(3);
        room14.setRating(0.0);

        Room room15 = new Room();
        room15.setId("samba.4401");
        room15.setStatus(RoomStatus.AVAILABLE);
        room15.setType(RoomType.QUAD);
        room15.setCapacity(4);
        ArrayList<Price> roomPrices15 = new ArrayList<>();
        roomPrices15.add(price57);
        roomPrices15.add(price57);
        roomPrices15.add(price59);
        roomPrices15.add(price60);
        room15.setPrices(roomPrices15);
        room15.setFloor(4);
        room15.setRating(0.0);

        Room room16 = new Room();
        room16.setId("samba.4402");
        room16.setStatus(RoomStatus.AVAILABLE);
        room16.setType(RoomType.QUAD);
        room16.setCapacity(4);
        ArrayList<Price> roomPrices16 = new ArrayList<>();
        roomPrices16.add(price61);
        roomPrices16.add(price62);
        roomPrices16.add(price63);
        roomPrices16.add(price64);
        room16.setPrices(roomPrices16);
        room16.setFloor(4);
        room16.setRating(0.0);
        
// end samba
                
// laurence
        Room room17 = new Room();
        room17.setId("laurence.1101");
        room17.setStatus(RoomStatus.AVAILABLE);
        room17.setType(RoomType.SINGLE);
        room17.setCapacity(1);
        room17.setFloor(1);
        ArrayList<Price> roomPrices17 = new ArrayList<>();
        roomPrices17.add(price65);
        roomPrices17.add(price66);
        roomPrices17.add(price67);
        roomPrices17.add(price68);
        room17.setPrices(roomPrices17);
        room17.setRating(0.0);

        Room room18 = new Room();
        room18.setId("laurence.1102");
        room18.setStatus(RoomStatus.AVAILABLE);
        room18.setType(RoomType.SINGLE);
        room18.setCapacity(1);
        ArrayList<Price> roomPrices18 = new ArrayList<>();
        roomPrices18.add(price69);
        roomPrices18.add(price70);
        roomPrices18.add(price71);
        roomPrices18.add(price72);
        room18.setPrices(roomPrices18);
        room18.setFloor(1);
        room18.setRating(0.0);

        Room room19 = new Room();
        room19.setId("laurence.2201");
        room19.setStatus(RoomStatus.AVAILABLE);
        room19.setType(RoomType.DOUBLE);
        room19.setCapacity(2);
        ArrayList<Price> roomPrices19 = new ArrayList<>();
        roomPrices19.add(price73);
        roomPrices19.add(price74);
        roomPrices19.add(price75);
        roomPrices19.add(price76);
        room19.setPrices(roomPrices19);
        room19.setFloor(2);
        room19.setRating(0.0);

        Room room20 = new Room();
        room20.setId("laurence.2202");
        room20.setStatus(RoomStatus.AVAILABLE);
        room20.setType(RoomType.DOUBLE);
        room20.setCapacity(2);
        ArrayList<Price> roomPrices20 = new ArrayList<>();
        roomPrices20.add(price77);
        roomPrices20.add(price78);
        roomPrices20.add(price79);
        roomPrices20.add(price80);
        room20.setPrices(roomPrices20);
        room20.setFloor(2);
        room20.setRating(0.0);

        Room room21 = new Room();
        room21.setId("laurence.2203");
        room21.setStatus(RoomStatus.AVAILABLE);
        room21.setType(RoomType.DOUBLE);
        room21.setCapacity(2);
        ArrayList<Price> roomPrices21 = new ArrayList<>();
        roomPrices21.add(price81);
        roomPrices21.add(price82);
        roomPrices21.add(price83);
        roomPrices21.add(price84);
        room21.setPrices(roomPrices21);
        room21.setFloor(2);
        room21.setRating(0.0);

        Room room22 = new Room();
        room22.setId("laurence.2301");
        room22.setStatus(RoomStatus.AVAILABLE);
        room22.setType(RoomType.TRIPLE);
        room22.setCapacity(3);
        ArrayList<Price> roomPrices22 = new ArrayList<>();
        roomPrices22.add(price85);
        roomPrices22.add(price86);
        roomPrices22.add(price87);
        roomPrices22.add(price88);
        room22.setPrices(roomPrices22);
        room22.setFloor(2);
        room22.setRating(0.0);

        Room room23 = new Room();
        room23.setId("laurence.2302");
        room23.setStatus(RoomStatus.AVAILABLE);
        room23.setType(RoomType.TRIPLE);
        room23.setCapacity(3);
        ArrayList<Price> roomPrices23 = new ArrayList<>();
        roomPrices23.add(price89);
        roomPrices23.add(price90);
        roomPrices23.add(price91);
        roomPrices23.add(price92);
        room23.setPrices(roomPrices23);
        room23.setFloor(2);
        room23.setRating(0.0);

        Room room24 = new Room();
        room24.setId("laurence.2303");
        room24.setStatus(RoomStatus.AVAILABLE);
        room24.setType(RoomType.TRIPLE);
        room24.setCapacity(3);
        ArrayList<Price> roomPrices24 = new ArrayList<>();
        roomPrices24.add(price93);
        roomPrices24.add(price94);
        roomPrices24.add(price95);
        roomPrices24.add(price96);
        room24.setPrices(roomPrices24);
        room24.setFloor(2);
        room24.setRating(0.0);
        
// end laurence
        
// ripamonti
        Room room25 = new Room();
        room25.setId("ripamonti.1101");
        room25.setStatus(RoomStatus.AVAILABLE);
        room25.setType(RoomType.SINGLE);
        room25.setCapacity(1);
        room25.setFloor(1);
        ArrayList<Price> roomPrices25 = new ArrayList<>();
        roomPrices25.add(price97);
        roomPrices25.add(price98);
        roomPrices25.add(price99);
        roomPrices25.add(price100);
        room25.setPrices(roomPrices25);
        room25.setRating(0.0);

        Room room26 = new Room();
        room26.setId("ripamonti.1102");
        room26.setStatus(RoomStatus.AVAILABLE);
        room26.setType(RoomType.SINGLE);
        room26.setCapacity(1);
        ArrayList<Price> roomPrices26 = new ArrayList<>();
        roomPrices26.add(price101);
        roomPrices26.add(price102);
        roomPrices26.add(price103);
        roomPrices26.add(price104);
        room26.setPrices(roomPrices26);
        room26.setFloor(1);
        room26.setRating(0.0);

        Room room27 = new Room();
        room27.setId("ripamonti.2201");
        room27.setStatus(RoomStatus.AVAILABLE);
        room27.setType(RoomType.DOUBLE);
        room27.setCapacity(2);
        ArrayList<Price> roomPrices27 = new ArrayList<>();
        roomPrices27.add(price105);
        roomPrices27.add(price106);
        roomPrices27.add(price107);
        roomPrices27.add(price108);
        room27.setPrices(roomPrices27);
        room27.setFloor(2);
        room27.setRating(0.0);

        Room room28 = new Room();
        room28.setId("ripamonti.2202");
        room28.setStatus(RoomStatus.AVAILABLE);
        room28.setType(RoomType.DOUBLE);
        room28.setCapacity(2);
        ArrayList<Price> roomPrices28 = new ArrayList<>();
        roomPrices28.add(price109);
        roomPrices28.add(price110);
        roomPrices28.add(price111);
        roomPrices28.add(price112);
        room28.setPrices(roomPrices28);
        room28.setFloor(2);
        room28.setRating(0.0);

        Room room29 = new Room();
        room29.setId("ripamonti.3201");
        room29.setStatus(RoomStatus.AVAILABLE);
        room29.setType(RoomType.DOUBLE);
        room29.setCapacity(2);
        ArrayList<Price> roomPrices29 = new ArrayList<>();
        roomPrices29.add(price113);
        roomPrices29.add(price114);
        roomPrices29.add(price115);
        roomPrices29.add(price116);
        room29.setPrices(roomPrices29);
        room29.setFloor(3);
        room29.setRating(0.0);

        Room room30 = new Room();
        room30.setId("ripamonti.3301");
        room30.setStatus(RoomStatus.AVAILABLE);
        room30.setType(RoomType.TRIPLE);
        room30.setCapacity(3);
        ArrayList<Price> roomPrices30 = new ArrayList<>();
        roomPrices30.add(price117);
        roomPrices30.add(price118);
        roomPrices30.add(price119);
        roomPrices30.add(price120);
        room30.setPrices(roomPrices30);
        room30.setFloor(3);
        room30.setRating(0.0);

        Room room31 = new Room();
        room31.setId("ripamonti.3302");
        room31.setStatus(RoomStatus.AVAILABLE);
        room31.setType(RoomType.TRIPLE);
        room31.setCapacity(3);
        ArrayList<Price> roomPrices31 = new ArrayList<>();
        roomPrices31.add(price121);
        roomPrices31.add(price122);
        roomPrices31.add(price123);
        roomPrices31.add(price124);
        room31.setPrices(roomPrices31);
        room31.setFloor(3);
        room31.setRating(0.0);

        Room room32 = new Room();
        room32.setId("ripamonti.4201");
        room32.setStatus(RoomStatus.AVAILABLE);
        room32.setType(RoomType.DOUBLE);
        room32.setCapacity(2);
        ArrayList<Price> roomPrices32 = new ArrayList<>();
        roomPrices32.add(price125);
        roomPrices32.add(price126);
        roomPrices32.add(price127);
        roomPrices32.add(price128);
        room32.setPrices(roomPrices32);
        room32.setFloor(4);
        room32.setRating(0.0);
        
        Room room33 = new Room();
        room33.setId("ripamonti.4101");
        room33.setStatus(RoomStatus.AVAILABLE);
        room33.setType(RoomType.SINGLE);
        room33.setCapacity(1);
        room33.setFloor(4);
        ArrayList<Price> roomPrices33 = new ArrayList<>();
        roomPrices33.add(price129);
        roomPrices33.add(price130);
        roomPrices33.add(price131);
        roomPrices33.add(price132);
        room33.setPrices(roomPrices33);
        room33.setRating(0.0);

        Room room34 = new Room();
        room34.setId("ripamonti.5101");
        room34.setStatus(RoomStatus.AVAILABLE);
        room34.setType(RoomType.SINGLE);
        room34.setCapacity(1);
        ArrayList<Price> roomPrices34 = new ArrayList<>();
        roomPrices34.add(price133);
        roomPrices34.add(price134);
        roomPrices34.add(price135);
        roomPrices34.add(price136);
        room34.setPrices(roomPrices34);
        room34.setFloor(5);
        room34.setRating(0.0);

        Room room35 = new Room();
        room35.setId("ripamonti.5201");
        room35.setStatus(RoomStatus.AVAILABLE);
        room35.setType(RoomType.DOUBLE);
        room35.setCapacity(2);
        ArrayList<Price> roomPrices35 = new ArrayList<>();
        roomPrices35.add(price137);
        roomPrices35.add(price138);
        roomPrices35.add(price139);
        roomPrices35.add(price140);
        room35.setPrices(roomPrices35);
        room35.setFloor(5);
        room35.setRating(0.0);

        Room room36 = new Room();
        room36.setId("ripamonti.6201");
        room36.setStatus(RoomStatus.AVAILABLE);
        room36.setType(RoomType.DOUBLE);
        room36.setCapacity(2);
        ArrayList<Price> roomPrices36 = new ArrayList<>();
        roomPrices36.add(price141);
        roomPrices36.add(price142);
        roomPrices36.add(price143);
        roomPrices36.add(price144);
        room36.setPrices(roomPrices36);
        room36.setFloor(6);
        room36.setRating(0.0);

        Room room37 = new Room();
        room37.setId("ripamonti.7201");
        room37.setStatus(RoomStatus.AVAILABLE);
        room37.setType(RoomType.DOUBLE);
        room37.setCapacity(2);
        ArrayList<Price> roomPrices37 = new ArrayList<>();
        roomPrices37.add(price145);
        roomPrices37.add(price146);
        roomPrices37.add(price147);
        roomPrices37.add(price148);
        room37.setPrices(roomPrices37);
        room37.setFloor(7);
        room37.setRating(0.0);

        Room room38 = new Room();
        room38.setId("ripamonti.7301");
        room38.setStatus(RoomStatus.AVAILABLE);
        room38.setType(RoomType.TRIPLE);
        room38.setCapacity(3);
        ArrayList<Price> roomPrices38 = new ArrayList<>();
        roomPrices38.add(price149);
        roomPrices38.add(price150);
        roomPrices38.add(price151);
        roomPrices38.add(price152);
        room38.setPrices(roomPrices38);
        room38.setFloor(7);
        room38.setRating(0.0);

        Room room39 = new Room();
        room39.setId("ripamonti.8301");
        room39.setStatus(RoomStatus.AVAILABLE);
        room39.setType(RoomType.TRIPLE);
        room39.setCapacity(3);
        ArrayList<Price> roomPrices39 = new ArrayList<>();
        roomPrices39.add(price153);
        roomPrices39.add(price154);
        roomPrices39.add(price155);
        roomPrices39.add(price156);
        room39.setPrices(roomPrices39);
        room39.setFloor(8);
        room39.setRating(0.0);

        Room room40 = new Room();
        room40.setId("ripamonti.9301");
        room40.setStatus(RoomStatus.AVAILABLE);
        room40.setType(RoomType.TRIPLE);
        room40.setCapacity(3);
        ArrayList<Price> roomPrices40 = new ArrayList<>();
        roomPrices40.add(price157);
        roomPrices40.add(price158);
        roomPrices40.add(price159);
        roomPrices40.add(price160);
        room40.setPrices(roomPrices40);
        room40.setFloor(9);
        room40.setRating(0.0);
        
        Room room41 = new Room();
        room41.setId("ripamonti.10201");
        room41.setStatus(RoomStatus.AVAILABLE);
        room41.setType(RoomType.DOUBLE);
        room41.setCapacity(2);
        ArrayList<Price> roomPrices41 = new ArrayList<>();
        roomPrices41.add(price161);
        roomPrices41.add(price162);
        roomPrices41.add(price163);
        roomPrices41.add(price164);
        room41.setPrices(roomPrices41);
        room41.setFloor(10);
        room41.setRating(0.0);

        Room room42 = new Room();
        room42.setId("ripamonti.10401");
        room42.setStatus(RoomStatus.AVAILABLE);
        room42.setType(RoomType.QUAD);
        room42.setCapacity(4);
        ArrayList<Price> roomPrices42 = new ArrayList<>();
        roomPrices42.add(price165);
        roomPrices42.add(price166);
        roomPrices42.add(price167);
        roomPrices42.add(price168);
        room42.setPrices(roomPrices42);
        room42.setFloor(10);
        room42.setRating(0.0);

        Room room43 = new Room();
        room43.setId("ripamonti.11201");
        room43.setStatus(RoomStatus.AVAILABLE);
        room43.setType(RoomType.DOUBLE);
        room43.setCapacity(2);
        ArrayList<Price> roomPrices43 = new ArrayList<>();
        roomPrices43.add(price169);
        roomPrices43.add(price170);
        roomPrices43.add(price171);
        roomPrices43.add(price172);
        room43.setPrices(roomPrices43);
        room43.setFloor(11);
        room43.setRating(0.0);

        Room room44 = new Room();
        room44.setId("ripamonti.11301");
        room44.setStatus(RoomStatus.AVAILABLE);
        room44.setType(RoomType.TRIPLE);
        room44.setCapacity(3);
        ArrayList<Price> roomPrices44 = new ArrayList<>();
        roomPrices44.add(price173);
        roomPrices44.add(price174);
        roomPrices44.add(price175);
        roomPrices44.add(price176);
        room44.setPrices(roomPrices44);
        room44.setFloor(11);
        room44.setRating(0.0);

        Room room45 = new Room();
        room45.setId("ripamonti.12301");
        room45.setStatus(RoomStatus.AVAILABLE);
        room45.setType(RoomType.TRIPLE);
        room45.setCapacity(3);
        ArrayList<Price> roomPrices45 = new ArrayList<>();
        roomPrices45.add(price177);
        roomPrices45.add(price178);
        roomPrices45.add(price179);
        roomPrices45.add(price180);
        room45.setPrices(roomPrices45);
        room45.setFloor(12);
        room45.setRating(0.0);

        Room room46 = new Room();
        room46.setId("ripamonti.12302");
        room46.setStatus(RoomStatus.AVAILABLE);
        room46.setType(RoomType.TRIPLE);
        room46.setCapacity(3);
        ArrayList<Price> roomPrices46 = new ArrayList<>();
        roomPrices46.add(price181);
        roomPrices46.add(price182);
        roomPrices46.add(price183);
        roomPrices46.add(price184);
        room46.setPrices(roomPrices46);
        room46.setFloor(12);
        room46.setRating(0.0);
        
// end ripamonti

        //Adding ROOMS to DB
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room1); rooms.add(room2); rooms.add(room3); rooms.add(room4); rooms.add(room5); rooms.add(room6); rooms.add(room7); rooms.add(room8);
        rooms.add(room9); rooms.add(room10); rooms.add(room11); rooms.add(room12); rooms.add(room13); rooms.add(room14); rooms.add(room15);
        rooms.add(room16); rooms.add(room17); rooms.add(room18); rooms.add(room19); rooms.add(room20); rooms.add(room21); rooms.add(room22);
        rooms.add(room23); rooms.add(room24); rooms.add(room25); rooms.add(room26); rooms.add(room27); rooms.add(room28); rooms.add(room29);
        rooms.add(room30); rooms.add(room31); rooms.add(room32); rooms.add(room33); rooms.add(room34); rooms.add(room35); rooms.add(room36);
        rooms.add(room37); rooms.add(room38); rooms.add(room39); rooms.add(room40); rooms.add(room41); rooms.add(room42); rooms.add(room43);
        rooms.add(room44); rooms.add(room45); rooms.add(room46);

        roomRepository.saveAll(rooms);


        //------------------ HOTELS ------------------//

        Hotel hotel1 = new Hotel("hotel_Felix_Krakow", "Hotel Felix",
        		new Address("Osiedle Zlotej Jesieni", "15", "Krakow", "Poland", new GPScoordinate(50.088092, 20.027914)),
                "+48 12 361 96 03", "felix@hotelfelix.pl",
                "Hotel Felix je hotel sa 2 zvezdice, smešten u četvrti Nova Huta u Krakovu. "
                        + "U ponudi su sobe s kupatilom i TV-om sa satelitskim kanalima. "
                        + "Na raspolaganju vam je besplatan bežični internet u zajedničkim prostorijama hotela."
                        + "Hotel je dobro povezan linijama tramvaja sa Glavnim trgom, četvrti Kazimir i Arenom Tauron."
                        + "Tokom boravka u hotelu Felix možete obići jedinstvenu četvrt Nova Huta, posetiti Glavni trg i livnicu Tadeuš Sendsimir."
                        + "U hotelu se služi doručak na bazi švedskog stola.",
                "http://www.hotelfelix.pl", 0.0, 3, 2,
                new ArrayList<Room>(Arrays.asList(
                        room1, room3, room5
                	)
                ),
                new ArrayList<AdditionalService>(Arrays.asList(
                        new AdditionalService((long) 1, "WIFI", 10),
                        new AdditionalService((long) 2, "PARKING", 0),
                        new AdditionalService((long) 7, "TV", 0),
                        new AdditionalService((long) 9, "BREAKFAST", 0),
                        new AdditionalService((long) 12, "PRIVATE BATHROOM", 0),
                        new AdditionalService((long) 19, "EXTRA BED", 20)
                )	// asList additional services end
                )
        );
        
        hotelRepository.save(hotel1);

	    Hotel hotel2 = new Hotel("hotel_Top_Prague", "Top Hotel",
	    		 new Address("Blazimska", "1781/4", "Prague", "Czech Republic", new GPScoordinate(50.041552, 14.496115)),
	             "+420 267 284 111", "booking@tophotel.cz",
	             "Objekat TOP HOTEL Praha smešten je na 800 metara od tržnog centra Chodov. "
	                     + "Poseduje bazen u zatvorenom, hidromasažnu kadu, solarijum, teretanu, kuglanu, nekoliko teniskih terena i 2 recepcije. "
	                     + "Do ovog smeštajnog objekta lako se dolazi sa auto-puta 1. Besplatan WiFi je dostupan u foajeu i u sobama."
	                     + "Od objekta TOP HOTEL Praha do centra grada možete da stignete za 25 minuta vožnje javnim prevozom. "
	                     + "Autobuska stanica se nalazi ispred same zgrade."
	                     + "U sobama su obezbeđeni Smart TV sa satelitskim kanalima i besplatan WiFi. "
	                     + "Pojedine sobe su klimatizovane. "
	                     + "Ponuda obuhvata i sobe za goste sa invaliditetom."
	                     + "Velnes i sportski sadržaji uključuju teretanu, parno kupatilo, bazen u zatvorenom i teniske terene na otvorenom i u zatvorenom. "
	                     + "Korišćenje ovih sadržaja dodatno se naplaćuje. "
	                     + "Kuglana objekta TOP HOTEL Praha radi do ponoći. "
	                     + "Na raspolaganju su vam i tajlandske masaže."
	                     + "U 5 restorana u okviru objekta služe se jela češke, indijske i internacionalne kuhinje. "
	                     + "Smeštajni objekat takođe nudi 3 bara, bar u foajeu sa zimskom baštom i prostor za sedenje na otvorenom. "
	                     + "U baru u foajeu možete da uživate u osveženjima. "
	                     + "U okviru objekta postoji i zimska bašta sa japanskim vrtom.",
	             "http://www.tophotel.cz", 0.0, 4, 4,
	             new ArrayList<Room>(Arrays.asList(
	                     room2, room4, room6, room7, room8
	            	)
	             ),
	             new ArrayList<AdditionalService>(Arrays.asList(
	                     new AdditionalService((long) 1, "WIFI", 0),
	                     new AdditionalService((long) 2, "PARKING", 0),
	                     new AdditionalService((long) 7, "TV", 0),
	                     new AdditionalService((long) 8, "AIR CONDITION", 20),
	                     new AdditionalService((long) 9, "BREAKFAST", 0),
	                     new AdditionalService((long) 10, "HALF BOARD", 0),
	                     new AdditionalService((long) 11, "FULL BOARD", 0),
	                     new AdditionalService((long) 12, "PRIVATE BATHROOM", 0),
	                     new AdditionalService((long) 13, "SWIMMING POOL", 20),
	                     new AdditionalService((long) 14, "WELLNESS", 40),
	                     new AdditionalService((long) 15, "TENNIS COURTS", 30),
	                     new AdditionalService((long) 16, "BOWLING HALL", 20),
	                     new AdditionalService((long) 17, "GYM", 15),
	                     new AdditionalService((long) 18, "SOLARIUM", 10),
	                     new AdditionalService((long) 19, "EXTRA BED", 30)
	            	)
	             )
	     );
	     
	     hotelRepository.save(hotel2);
     
	     Hotel hotel3 = new Hotel("hotel_Samba_Lloret_de_Mar", "Hotel Samba",
	    		 new Address("Francesc Cambo", "10", "Lloret de Mar", "Spain", new GPScoordinate(41.698953, 2.836811)),
	             "+34 972 36 56 50", "info@sambahotels.com",
	             "A seasonal outdoor pool and views over Lloret are offered at Samba, situated 500 m from Fenals Beach. A private balcony can be found in each functional room.\r\n" + 
	             "\r\n" + 
	             "Samba is situated in a quiet area, just a 10-minute walk from Lloret de Mar’s lively centre. Lloret Bus Station is 600 m away and offers direct services to Girona Airport and Barcelona.\r\n" + 
	             "\r\n" + 
	             "Samba’s bright rooms offer satellite TV and views of the swimming pool, street or hills. Each room includes wooden furniture and you can hire the safe. Wi-Fi is available in rooms for an extra charge.\r\n" + 
	             "\r\n" + 
	             "Local and international cuisine is served in the Samba’s buffet restaurant. Themed dinners are offered during the high season. There is also an English-style pub, open in summer.\r\n" + 
	             "\r\n" + 
	             "This is our guests' favorite part of Lloret de Mar, according to independent reviews.",
	             "https://www.sambahotels.com/en/hotel-samba", 0.0, 5, 3,
	             new ArrayList<Room>(Arrays.asList(
	                     room9, room10, room11, room12, room13, room14, room15, room16
	             	)
	             ),
	             new ArrayList<AdditionalService>(Arrays.asList(
	                     new AdditionalService((long) 1, "WIFI", 10),
	                     new AdditionalService((long) 2, "PARKING", 0),
	                     new AdditionalService((long) 7, "TV", 0),
	                     new AdditionalService((long) 8, "AIR CONDITION", 20),
	                     new AdditionalService((long) 9, "BREAKFAST", 0),
	                     new AdditionalService((long) 12, "PRIVATE BATHROOM", 0),
	                     new AdditionalService((long) 13, "SWIMMING POOL", 0),
	                     new AdditionalService((long) 17, "GYM", 10),
	                     new AdditionalService((long) 18, "SOLARIUM", 5),
	                     new AdditionalService((long) 19, "EXTRA BED", 20)
	             )	// asList additional services end
	             )
	     );
	     
	     hotelRepository.save(hotel3);
     
	     Hotel hotel4 = new Hotel("hotel_Laurence_Rome", "Hotel Laurence",
	    		 new Address("Via Pietro Baragiola", "18/24", "Rome", "Italy", new GPScoordinate(41.848485, 12.623351)),
	             "+39 06 2042 7050", "hotellaurence.rome@gmail.com",
	             "Set within the campus of Rome's Tor Vergata University, Hotel Laurence offers air-conditioned rooms with free Wi-Fi and an on-site gaming room equipped with computers. Parking is free.\r\n" + 
	             "\r\n" + 
	             "Each with direct access to the garden, rooms here come with satellite LCD TV, a minibar, and a private bathroom with hairdryer. A buffet breakfast is served each morning.\r\n" + 
	             "\r\n" + 
	             "The Laurence is 350 m from Tor Vergata Shopping Centre and 500 m from Tor Vergata Policlinico Hospital. You can walk to the Economy and Literature faculties.\r\n" + 
	             "\r\n" + 
	             "Ciampino Airport is 6 km away and there are regular buses to Anagnina Metro Station, terminus of Line A.",
	             "http://hotellaurence.com", 0.0, 2, 3,
	             new ArrayList<Room>(Arrays.asList(
	                     room17, room18, room19, room20, room21, room22, room23, room24
	             	)
	             ),
	             new ArrayList<AdditionalService>(Arrays.asList(
	                     new AdditionalService((long) 1, "WIFI", 0),
	                     new AdditionalService((long) 2, "PARKING", 0),
	                     new AdditionalService((long) 7, "TV", 0),
	                     new AdditionalService((long) 8, "AIR CONDITION", 20),
	                     new AdditionalService((long) 12, "PRIVATE BATHROOM", 0),
	                     new AdditionalService((long) 19, "EXTRA BED", 20)
	             )	// asList additional services end
	             )
	     );
	     
	     hotelRepository.save(hotel4);
	     
	     Hotel hotel5 = new Hotel("hotel_Ripamonti_Milano", "Hotel Ripamonti",
	    		 new Address("Via dei Pini", "4", "Milano", "Italy", new GPScoordinate(45.348011, 9.199687)),
	             "+39 02 90761", "info@ripamontiresidence.it",
	             "Ripamonti Residence & Hotel Milano is set in Milan's quiet Parco Sud park. It offers comfortable rooms and self-catering apartments, and a free shuttle bus to/from city centre and to/from Abbiategrasso Metro station.\r\n" + 
	             "\r\n" + 
	             "Rooms at the Ripamonti come with air conditioning and a private bathroom with free toiletries. Apartments are provided with a kitchen or kitchenette. A buffet breakfast is available daily and there is also a restaurant/pizzeria on site.\r\n" + 
	             "\r\n" + 
	             "Pieve Emanuele Station, on the S13 line, is 1.4 km from the property. From here, central Milan is a 10-minute train ride away.",
	             "https://www.ripamontiresidencehotel.com", 0.0, 12, 4,
	             new ArrayList<Room>(Arrays.asList(
	                     room25, room26, room27, room28, room29, room30, room31, room32, room33, room34,
	                     room35, room36, room37, room38, room39, room40, room41, room42, room43, room44,
	                     room45, room46
	             	)
	             ),
	             new ArrayList<AdditionalService>(Arrays.asList(
	                     new AdditionalService((long) 1, "WIFI", 10),
	                     new AdditionalService((long) 2, "PARKING", 0),
	                     new AdditionalService((long) 3, "AIRPORT TRANSFER", 20),
	                     new AdditionalService((long) 6, "KITCHEN", 0),
	                     new AdditionalService((long) 7, "TV", 0),
	                     new AdditionalService((long) 8, "AIR CONDITION", 20),
	                     new AdditionalService((long) 12, "PRIVATE BATHROOM", 0),
	                     new AdditionalService((long) 17, "GYM", 15),
	                     new AdditionalService((long) 19, "EXTRA BED", 20)
	             )	// asList additional services end
	             )
	     );
	     
	     hotelRepository.save(hotel5);
	     
	     

	    //---------------- ADMINISTRATORS ----------------//
	    Administrator admin1 = new Administrator(
	            "sys_admin1",
	            "sys_admin1@isa.com",
	            "sys_admin1",
	            AdministatorType.SYSTEM_ADMIN
	    );
	
	    Administrator admin2 = new Administrator(
	            "air_admin",
	            "air_admin@isa.com",
	            "air_admin",
	            AdministatorType.AIRLINE_ADMIN
	    );
	
	    Administrator admin3 = new Administrator(
	            "hotel_admin",
	            "hotel_admin@isa.com",
	            "hotel_admin",
	            AdministatorType.HOTEL_ADMIN
	    );
	    
	    Administrator admin5 = new Administrator(
	            "hotel_admin_2",
	            "hotel_admin_2@isa.com",
	            "hotel_admin_2",
	            AdministatorType.HOTEL_ADMIN
	    );
	    
	    Administrator admin6 = new Administrator(
	            "hotel_admin_3",
	            "hotel_admin_3@isa.com",
	            "hotel_admin_3",
	            AdministatorType.HOTEL_ADMIN
	    );
	    
	    Administrator admin7 = new Administrator(
	            "hotel_admin_4",
	            "hotel_admin_4@isa.com",
	            "hotel_admin_4",
	            AdministatorType.HOTEL_ADMIN
	    );
	    
	    Administrator admin8 = new Administrator(
	            "hotel_admin_5",
	            "hotel_admin_5@isa.com",
	            "hotel_admin_5",
	            AdministatorType.HOTEL_ADMIN
	    );
	
	    admin3.setEditingObjectID(hotel1.getId());
	    admin5.setEditingObjectID(hotel2.getId());
	    admin6.setEditingObjectID(hotel3.getId());
	    admin7.setEditingObjectID(hotel4.getId());
	    admin8.setEditingObjectID(hotel5.getId());
	
	    ArrayList<Administrator> admins = new ArrayList<Administrator>();
	    admins.add(admin1); admins.add(admin2); admins.add(admin3); admins.add(admin5); admins.add(admin6); admins.add(admin7);
	    admins.add(admin8);
	    
	    administratorRepository.saveAll(admins);


    }
}
