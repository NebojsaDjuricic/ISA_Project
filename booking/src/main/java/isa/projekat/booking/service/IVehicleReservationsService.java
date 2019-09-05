package isa.projekat.booking.service;

import isa.projekat.booking.domain.VehicleReservation;

import java.util.List;
import java.util.Map;

public interface IVehicleReservationsService {

    VehicleReservation save(VehicleReservation reservation);
    List<VehicleReservation> findByVehicleID(String id);
    List<VehicleReservation> findByVehicleAndRentACarServiceID(String vehicleID, String rentACarServiceID);

}
