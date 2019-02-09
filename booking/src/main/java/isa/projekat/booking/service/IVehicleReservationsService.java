package isa.projekat.booking.service;

import isa.projekat.booking.domain.VehicleReservation;

import java.util.List;

public interface IVehicleReservationsService {

    VehicleReservation save(VehicleReservation reservation);
    List<VehicleReservation> findByVehicleID(String id);

}
