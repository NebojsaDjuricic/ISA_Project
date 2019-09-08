package isa.projekat.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import isa.projekat.booking.domain.Address;
import isa.projekat.booking.domain.AdministatorType;
import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.domain.Branch;
import isa.projekat.booking.domain.GPScoordinate;
import isa.projekat.booking.domain.RentACarService;
import isa.projekat.booking.domain.Vehicle;
import isa.projekat.booking.domain.VehicleDiscount;
import isa.projekat.booking.domain.VehicleReservation;
import isa.projekat.booking.domain.VehicleStatus;
import isa.projekat.booking.domain.VehicleType;
import isa.projekat.booking.repository.AdministratorRepository;
import isa.projekat.booking.repository.BranchRepository;
import isa.projekat.booking.repository.RentACarServiceRepository;
import isa.projekat.booking.repository.VehicleRepository;
import isa.projekat.booking.repository.VehicleReservationsRepository;

@Component
public class RentACarDBSeeder implements CommandLineRunner {
	
	@Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private RentACarServiceRepository rentACarServiceRepository;
    
    @Autowired
    private AdministratorRepository administratorRepository;
    
    @Autowired
    private VehicleReservationsRepository vehicleReservationRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		vehicleRepository.deleteAll();
        branchRepository.deleteAll();
        rentACarServiceRepository.deleteAll();
        vehicleReservationRepository.deleteAll();
        
      //---------------- VEHICLES ----------------//
        Vehicle v1 = new Vehicle();
        v1.setName("Fiat Punto");
        v1.setBrand("Fiat");
        v1.setModel("Punto");
        v1.setLicenceID("NS-123-XZ");
        v1.setManufacturingYear(2007);
        v1.setNumberOfSeats(4);
        v1.setPrice(100.0);
        v1.setRating(4.2);
        v1.setVehicleType(VehicleType.SEDAN);
        v1.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v2 = new Vehicle();
        v2.setName("Tesla Model 3");
        v2.setBrand("Tesla");
        v2.setModel("Model 3");
        v2.setLicenceID("NS-345-TS");
        v2.setManufacturingYear(2013);
        v2.setNumberOfSeats(2);
        v2.setPrice(1100.0);
        v2.setRating(4.9);
        v2.setVehicleType(VehicleType.MPV);
        v2.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v3 = new Vehicle();
        v3.setName("Open Astra");
        v3.setBrand("Opel");
        v3.setModel("Astra");
        v3.setLicenceID("NS-156-PF");
        v3.setManufacturingYear(2004);
        v3.setNumberOfSeats(4);
        v3.setPrice(120.0);
        v3.setRating(4.1);
        v3.setVehicleType(VehicleType.SEDAN);
        v3.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v4 = new Vehicle();
        v4.setName("Toyota Yaris");
        v4.setBrand("Toyota");
        v4.setModel("Yaris");
        v4.setLicenceID("NS-543-EZ");
        v4.setManufacturingYear(2001);
        v4.setNumberOfSeats(4);
        v4.setPrice(110.0);
        v4.setRating(3.2);
        v4.setVehicleType(VehicleType.CROSSOVER);
        v4.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v5 = new Vehicle();
        v5.setName("Zastava Yugo");
        v5.setBrand("Zastava");
        v5.setModel("Yugo");
        v5.setLicenceID("NS-555-YU");
        v5.setManufacturingYear(1979);
        v5.setNumberOfSeats(4);
        v5.setPrice(50.0);
        v5.setRating(5.0);
        v5.setVehicleType(VehicleType.MPV);
        v5.setStatus(VehicleStatus.IN_SERVICE);

        Vehicle v6 = new Vehicle();
        v6.setName("Zastava Stojadin");
        v6.setBrand("Zastava");
        v6.setModel("Stojadin");
        v6.setLicenceID("NS-123-YU");
        v6.setManufacturingYear(1975);
        v6.setNumberOfSeats(4);
        v6.setPrice(50.0);
        v6.setRating(5.0);
        v6.setVehicleType(VehicleType.CROSSOVER);
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
        GPScoordinate coord1 = new GPScoordinate();
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
        GPScoordinate coord2 = new GPScoordinate();
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
        GPScoordinate coord3 = new GPScoordinate();
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
        
        rent1.getVehicles().put(v1.getLicenceID(), v1.getLicenceID());
        rent1.getVehicles().put(v2.getLicenceID(), v2.getLicenceID());
        rent1.getVehicles().put(v3.getLicenceID(), v3.getLicenceID());
        rent1.getVehicles().put(v4.getLicenceID(), v4.getLicenceID());
        
        ArrayList<String> b1vehs = new ArrayList<String>();
        b1vehs.add(v1.getLicenceID());
        b1vehs.add(v2.getLicenceID());
        ArrayList<String> b2vehs = new ArrayList<String>();
        b2vehs.add(v3.getLicenceID());
        b2vehs.add(v4.getLicenceID());
        
        rent1.getBranchesAndVehicles().put(branch1.getId(), b1vehs);
        rent1.getBranchesAndVehicles().put(branch2.getId(), b2vehs);
        
        VehicleDiscount vehDis1 = new VehicleDiscount();
        vehDis1.setVehicleID(v1.getLicenceID());
        vehDis1.setDiscount(10.0);
        LocalDate sd1 = LocalDate.of(2019, 8, 11);
        vehDis1.setDiscountStartDate(sd1);
        vehDis1.setDiscountEndDate(LocalDate.of(2019, 8, 30));
        
        ArrayList<VehicleDiscount> vehdisclist1 = new ArrayList<VehicleDiscount>();
        vehdisclist1.add(vehDis1);
        rent1.setVehiclesOnDiscount(vehdisclist1);

        
        RentACarService rent2 = new RentACarService();
        rent2.setId(Calendar.getInstance().getTimeInMillis()+"2");
        rent2.setAddress(adrs3);
        ArrayList<Branch> branches2 = new ArrayList<>();
        branches2.add(branch3);
        rent2.setBranches(branches2);
        rent2.setDescription("Najjeftinija vozila za iznajmljivanje");
        rent2.setName("Cheap rent");
        rent2.setRating(4.4);
        
        rent2.getVehicles().put(v5.getLicenceID(), v5.getLicenceID());
        rent2.getVehicles().put(v6.getLicenceID(), v6.getLicenceID());
        
        ArrayList<String> b3vehs = new ArrayList<String>();
        b3vehs.add(v5.getLicenceID());
        b3vehs.add(v6.getLicenceID());
        
        rent2.getBranchesAndVehicles().put(branch3.getId(), b3vehs);

        ArrayList<RentACarService> carRents = new ArrayList<>();
        carRents.add(rent1);
        carRents.add(rent2);

        rentACarServiceRepository.saveAll(carRents);
        
      //---------------- ADMINISTRATORS ----------------//
        
        Administrator admin4 = new Administrator(
                "car_admin",
                "car_admin@isa.com",
                "car_admin",
                AdministatorType.RENT_A_CAR_SERVICE_ADMIN
        );
        
        admin4.setEditingObjectID(rent1.getId());
        
        administratorRepository.insert(admin4);
        
        
      //---------------- RESERVATIONS ----------------//
        
        VehicleReservation vehRes1 = new VehicleReservation();
        vehRes1.setStartDate(LocalDate.of(2019, 5, 12));
        vehRes1.setEndDate(LocalDate.of(2019, 5, 15));
        vehRes1.setVehicleID(v1.getLicenceID());
        vehRes1.setRating(4.5);
        vehRes1.setPickUpLocation("Pickup Address 1");
        vehRes1.setDropUpLocation("Dropup Address 1");
        vehRes1.setRentACarServiceID(rent1.getId());
        
        vehicleReservationRepository.insert(vehRes1);
		
	}

}
