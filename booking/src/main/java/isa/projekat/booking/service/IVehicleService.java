package isa.projekat.booking.service;

import java.util.List;

import isa.projekat.booking.domain.Vehicle;
import isa.projekat.booking.domain.VehicleType;

public interface IVehicleService {

    Vehicle save(Vehicle vehicle);
    Vehicle findByID(String id);
    List<Vehicle> findByVehicleType(VehicleType type);
}
