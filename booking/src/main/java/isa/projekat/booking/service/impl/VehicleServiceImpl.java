package isa.projekat.booking.service.impl;

import isa.projekat.booking.domain.Vehicle;
import isa.projekat.booking.repository.VehicleRepository;
import isa.projekat.booking.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findByID(String id) {

        Optional<Vehicle> queryResult = vehicleRepository.findById(id);

        if(queryResult.isPresent()) {
            return queryResult.get();
        }
        else {
            return null;
        }
    }
}
