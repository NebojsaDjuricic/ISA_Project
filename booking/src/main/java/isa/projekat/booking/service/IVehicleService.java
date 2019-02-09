package isa.projekat.booking.service;

import isa.projekat.booking.domain.Vehicle;

public interface IVehicleService {

    Vehicle save(Vehicle vehicle);
    Vehicle findByID(String id);
}
