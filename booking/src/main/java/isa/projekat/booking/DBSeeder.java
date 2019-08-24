package isa.projekat.booking;

import isa.projekat.booking.domain.*;
import isa.projekat.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

@Component
public class DBSeeder implements CommandLineRunner {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private RentACarServiceRepository rentACarServiceRepository;

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
        vehicleRepository.deleteAll();
        branchRepository.deleteAll();
        rentACarServiceRepository.deleteAll();
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

        //---------------- VEHICLES ----------------//
        Vehicle v1 = new Vehicle();
        v1.setBrand("Fiat");
        v1.setModel("Punto");
        v1.setLicenceID("NS-123-XZ");
        v1.setPrice(100.0);
        v1.setRating(4.2);
        v1.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v2 = new Vehicle();
        v2.setBrand("Tesla");
        v2.setModel("Model 3");
        v2.setLicenceID("NS-345-TS");
        v2.setPrice(1100.0);
        v2.setRating(4.9);
        v2.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v3 = new Vehicle();
        v3.setBrand("Opel");
        v3.setModel("Astra");
        v3.setLicenceID("NS-156-PF");
        v3.setPrice(120.0);
        v3.setRating(4.1);
        v3.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v4 = new Vehicle();
        v4.setBrand("Toyota");
        v4.setModel("Yaris");
        v4.setLicenceID("NS-543-EZ");
        v4.setPrice(110.0);
        v4.setRating(3.2);
        v4.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v5 = new Vehicle();
        v5.setBrand("Zastava");
        v5.setModel("Yugo");
        v5.setLicenceID("NS-555-YU");
        v5.setPrice(50.0);
        v5.setRating(5.0);
        v5.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v6 = new Vehicle();
        v6.setBrand("Zastava");
        v6.setModel("Stojadin");
        v6.setLicenceID("NS-123-YU");
        v6.setPrice(50.0);
        v6.setRating(5.0);
        v6.setStatus(VehicleStatus.OUT_OF_SERVICE);


        //Adding vehicles to DB
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
        vehicles.add(v4);
        vehicles.add(v5);
        vehicles.add(v6);
        vehicleRepository.saveAll(vehicles);


        //---------------- BRANCHES ----------------//
        // x3 (2 - 2 - 2)

        Branch branch1 = new Branch();
        branch1.setId(Calendar.getInstance().getTimeInMillis()+"1");
        Address adrs1 = new Address();
        adrs1.setStreetName("Danila Kiša");
        adrs1.setBuildingNumber("12");
        adrs1.setCity("Novi Sad");
        adrs1.setCountry("Serbia");
        GSPcoordinate coord1 = new GSPcoordinate();
        coord1.setLatitude(45.248);
        coord1.setLongitude(19.837);
        adrs1.setCoordinatePosition(coord1);
        branch1.setAddress(adrs1);
        branch1.setContactEmail("office1@auto.rs");
        branch1.setName("Auto Filijala");
        branch1.setPhoneNumber("+381 61 11 11 111");
        ArrayList<Vehicle> vehs1 = new ArrayList<>();
        vehs1.add(v1);
        vehs1.add(v2);
        branch1.setVehicles(vehs1);

        Branch branch2 = new Branch();
        branch2.setId(Calendar.getInstance().getTimeInMillis()+"2");
        Address adrs2 = new Address();
        adrs2.setStreetName("Temerinska");
        adrs2.setBuildingNumber("30");
        adrs2.setCity("Novi Sad");
        adrs2.setCountry("Serbia");
        GSPcoordinate coord2 = new GSPcoordinate();
        coord2.setLatitude(45.264);
        coord2.setLongitude(19.844);
        adrs2.setCoordinatePosition(coord2);
        branch2.setAddress(adrs2);
        branch2.setContactEmail("info@rentcar.rs");
        branch2.setName("Rent Car");
        branch2.setPhoneNumber("+381 62 22 22 222");
        ArrayList<Vehicle> vehs2 = new ArrayList<>();
        vehs2.add(v3);
        vehs2.add(v4);
        branch2.setVehicles(vehs2);

        Branch branch3 = new Branch();
        branch3.setId(Calendar.getInstance().getTimeInMillis()+"3");
        Address adrs3 = new Address();
        adrs3.setStreetName("Ćirpanova");
        adrs3.setBuildingNumber("8");
        adrs3.setCity("Novi Sad");
        adrs3.setCountry("Serbia");
        GSPcoordinate coord3 = new GSPcoordinate();
        coord3.setLatitude(45.252);
        coord3.setLongitude(19.833);
        adrs3.setCoordinatePosition(coord3);
        branch3.setAddress(adrs3);
        branch3.setContactEmail("contact@brmbrm.rs");
        branch3.setName("Brm brm car");
        branch3.setPhoneNumber("+381 63 33 33 333");
        ArrayList<Vehicle> vehs3 = new ArrayList<>();
        vehs3.add(v5);
        vehs3.add(v6);
        branch3.setVehicles(vehs3);

        //Adding branches to DB
        ArrayList<Branch> branches = new ArrayList<>();
        branches.add(branch1);
        branches.add(branch2);
        branches.add(branch3);

        branchRepository.saveAll(branches);


        //---------------- RENT-A-CAR SERVICES ----------------//
        // x2 (2 - 1)

        RentACarService rent1 = new RentACarService();
        rent1.setId(Calendar.getInstance().getTimeInMillis()+"1");
        rent1.setAddress(adrs1);
        ArrayList<Branch> branches1 = new ArrayList<>();
        branches1.add(branch1);
        branches1.add(branch2);
        rent1.setBranches(branches1);
        rent1.setDescription("Prvi osnovani Rent-a-Car servis");
        rent1.setName("Giga rent");
        rent1.setRating(4.0);

        RentACarService rent2 = new RentACarService();
        rent2.setId(Calendar.getInstance().getTimeInMillis()+"2");
        rent2.setAddress(adrs3);
        ArrayList<Branch> branches2 = new ArrayList<>();
        branches2.add(branch3);
        rent2.setBranches(branches2);
        rent2.setDescription("Najjeftinija vozila za iznajmljivanje");
        rent2.setName("Cheap rent");
        rent2.setRating(4.4);

        ArrayList<RentACarService> carRents = new ArrayList<>();
        carRents.add(rent1);
        carRents.add(rent2);

        rentACarServiceRepository.saveAll(carRents);

        //-------------- ADDITIONAL SERVICES --------------//

        AdditionalService addService1 = new AdditionalService();
        addService1.setId(1);
        addService1.setService("WIFI");

        AdditionalService addService2 = new AdditionalService();
        addService2.setId(2);
        addService2.setService("PARKING");

        AdditionalService addService3 = new AdditionalService();
        addService3.setId(3);
        addService3.setService("AIRPORT TRANSFER");

        AdditionalService addService4 = new AdditionalService();
        addService4.setId(4);
        addService4.setService("ROOM SERVICE");

        AdditionalService addService5 = new AdditionalService();
        addService5.setId(5);
        addService5.setService("MINI BAR");

        AdditionalService addService6 = new AdditionalService();
        addService6.setId(6);
        addService6.setService("KITCHEN");

        AdditionalService addService7 = new AdditionalService();
        addService7.setId(7);
        addService7.setService("TV");

        AdditionalService addService8 = new AdditionalService();
        addService8.setId(8);
        addService8.setService("AIR CONDITION");

        AdditionalService addService9 = new AdditionalService();
        addService9.setId(9);
        addService9.setService("BREAKFAST");

        AdditionalService addService10 = new AdditionalService();
        addService10.setId(10);
        addService10.setService("HALF BOARD");

        AdditionalService addService11 = new AdditionalService();
        addService11.setId(11);
        addService11.setService("FULL BOARD");

        AdditionalService addService12 = new AdditionalService();
        addService12.setId(12);
        addService12.setService("PRIVATE BATHROOM");

        AdditionalService addService13 = new AdditionalService();
        addService13.setId(13);
        addService13.setService("SWIMMING POOL");

        AdditionalService addService14 = new AdditionalService();
        addService14.setId(14);
        addService14.setService("WELLNESS");

        AdditionalService addService15 = new AdditionalService();
        addService15.setId(15);
        addService15.setService("TENNIS COURTS");

        AdditionalService addService16 = new AdditionalService();
        addService16.setId(16);
        addService16.setService("BOWLING HALL");

        AdditionalService addService17 = new AdditionalService();
        addService17.setId(17);
        addService17.setService("GYM");

        AdditionalService addService18 = new AdditionalService();
        addService18.setId(18);
        addService18.setService("SOLARIUM");
        
        AdditionalService addService19 = new AdditionalService();
        addService19.setId(19);
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
                "Hotel Felix", new Address("Osiedle Złotej Jesieni", "15", "Kraków", "Poland", new GSPcoordinate(50.088, 20.028)),
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
                        new AdditionalService(1, "WIFI", 0),
                        new AdditionalService(2, "PARKING", 0),
                        new AdditionalService(7, "TV", 0),
                        new AdditionalService(9, "BREAKFAST", 0),
                        new AdditionalService(12, "PRIVATE BATHROOM", 0)
                )	// asList additional services end
                )
        );
        
     hotelRepository.save(hotel1);

     Hotel hotel2 = new Hotel("hotel_Top_Prague",
             "Top Hotel", new Address("Blažimská", "1781/4", "Prague", "Czech Republic", new GSPcoordinate(50.041, 14.495)),
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
                     new AdditionalService(1, "WIFI", 0),
                     new AdditionalService(2, "PARKING", 0),
                     new AdditionalService(7, "TV", 0),
                     new AdditionalService(8, "AIR CONDITION", 20),
                     new AdditionalService(9, "BREAKFAST", 0),
                     new AdditionalService(10, "HALF BOARD", 0),
                     new AdditionalService(11, "FULL BOARD", 0),
                     new AdditionalService(12, "PRIVATE BATHROOM", 0),
                     new AdditionalService(13, "SWIMMING POOL", 20),
                     new AdditionalService(14, "WELLNESS", 40),
                     new AdditionalService(15, "TENNIS COURTS", 30),
                     new AdditionalService(16, "BOWLING HALL", 20),
                     new AdditionalService(17, "GYM", 15),
                     new AdditionalService(18, "SOLARIUM", 10)
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
                "car_admin",
                "car_admin@isa.com",
                "car_admin",
                AdministatorType.RENT_A_CAR_SERVICE_ADMIN
        );

        admin3.setEditingObjectID(hotel1.getId());
        admin4.setEditingObjectID(rent1.getId());

        ArrayList<Administrator> admins = new ArrayList<Administrator>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);
        admins.add(admin4);

        administratorRepository.saveAll(admins);


    }
}
