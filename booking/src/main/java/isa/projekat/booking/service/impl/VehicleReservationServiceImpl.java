package isa.projekat.booking.service.impl;

import isa.projekat.booking.domain.VehicleReservation;
import isa.projekat.booking.repository.VehicleReservationsRepository;
import isa.projekat.booking.service.IVehicleReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleReservationServiceImpl implements IVehicleReservationsService {

    @Autowired
    VehicleReservationsRepository vehicleReservationsRepository;

    @Override
    public VehicleReservation save(VehicleReservation reservation) {
        return vehicleReservationsRepository.save(reservation);
    }

    @Override
    public List<VehicleReservation> findByVehicleID(String id) {

        BasicQuery query = new BasicQuery("{ vehicleID: id}");



        List<VehicleReservation> reservation = vehicleReservationsRepository.findAll();

        return null;
    }
}
