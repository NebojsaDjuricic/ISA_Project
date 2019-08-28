package isa.projekat.booking;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        
        roomRepository.deleteAll();
        hotelRepository.deleteAll();
        additionalServiceRepository.deleteAll();
        administratorRepository.deleteAll();

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
        additionalServices.add(addService1);
        additionalServices.add(addService2);
        additionalServices.add(addService3);
        additionalServices.add(addService4);
        additionalServices.add(addService5);
        additionalServices.add(addService6);
        additionalServices.add(addService7);
        additionalServices.add(addService8);
        additionalServices.add(addService9);
        additionalServices.add(addService10);
        additionalServices.add(addService11);
        additionalServices.add(addService12);
        additionalServices.add(addService13);
        additionalServices.add(addService14);
        additionalServices.add(addService15);
        additionalServices.add(addService16);
        additionalServices.add(addService17);
        additionalServices.add(addService18);
        additionalServices.add(addService19);

        additionalServiceRepository.saveAll(additionalServices);


        //------------------ ROOMS ------------------//

        Room room1 = new Room();
        room1.setId("felix.1101");
        room1.setStatus(RoomStatus.AVAILABLE);
        room1.setType(RoomType.SINGLE);
        room1.setCapacity(1);
        room1.setFloor(1);
        
        // cene za svaku sobu u odredjenom periodu
        room1.setPricePerNight(30);
        room1.setRating(0.0);

        Room room2 = new Room();
        room2.setId("top.1101");
        room2.setStatus(RoomStatus.AVAILABLE);
        room2.setType(RoomType.SINGLE);
        room2.setCapacity(1);
        room2.setPricePerNight(36);
        room2.setFloor(1);
        room2.setRating(0.0);

        Room room3 = new Room();
        room3.setId("felix.2201");
        room3.setStatus(RoomStatus.AVAILABLE);
        room3.setType(RoomType.DOUBLE);
        room3.setCapacity(2);
        room3.setPricePerNight(42);
        room3.setFloor(2);
        room3.setRating(0.0);

        Room room4 = new Room();
        room4.setId("top.2201");
        room4.setStatus(RoomStatus.AVAILABLE);
        room4.setType(RoomType.DOUBLE);
        room4.setCapacity(2);
        room4.setPricePerNight(46);
        room4.setFloor(2);
        room4.setRating(0.0);

        Room room5 = new Room();
        room5.setId("felix.3301");
        room5.setStatus(RoomStatus.AVAILABLE);
        room5.setType(RoomType.TRIPLE);
        room5.setCapacity(3);
        room5.setPricePerNight(33);
        room5.setFloor(3);
        room5.setRating(0.0);

        Room room6 = new Room();
        room6.setId("top.3301");
        room6.setStatus(RoomStatus.AVAILABLE);
        room6.setType(RoomType.TRIPLE);
        room6.setCapacity(3);
        room6.setPricePerNight(43);
        room6.setFloor(3);
        room6.setRating(0.0);

        Room room7 = new Room();
        room7.setId("top.4401");
        room7.setStatus(RoomStatus.AVAILABLE);
        room7.setType(RoomType.QUAD);
        room7.setCapacity(4);
        room7.setPricePerNight(26);
        room7.setFloor(4);
        room7.setRating(0.0);

        Room room8 = new Room();
        room8.setId("top.4402");
        room8.setStatus(RoomStatus.AVAILABLE);
        room8.setType(RoomType.QUAD);
        room8.setCapacity(4);
        room8.setPricePerNight(31);
        room8.setFloor(4);
        room8.setRating(0.0);

        //Adding ROOMS to DB
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);

        roomRepository.saveAll(rooms);


        //------------------ HOTELS ------------------//

        Hotel hotel1 = new Hotel("hotel_Felix_Krakow",
                "Hotel Felix", new Address("Osiedle Złotej Jesieni", "15", "Kraków", "Poland", new GPScoordinate(50.088, 20.028)),
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

     Hotel hotel2 = new Hotel("hotel_Top_Prague",
             "Top Hotel", new Address("Blažimská", "1781/4", "Prague", "Czech Republic", new GPScoordinate(50.041, 14.495)),
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
        
        Administrator admin4 = new Administrator(
                "hotel_admin_2",
                "hotel_admin_2@isa.com",
                "hotel_admin_2",
                AdministatorType.HOTEL_ADMIN
        );

        admin3.setEditingObjectID(hotel1.getId());
        admin4.setEditingObjectID(hotel2.getId());
        

        ArrayList<Administrator> admins = new ArrayList<Administrator>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);
        admins.add(admin4);
        

        administratorRepository.saveAll(admins);


    }
}
