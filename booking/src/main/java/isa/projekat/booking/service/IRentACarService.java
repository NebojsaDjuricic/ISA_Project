package isa.projekat.booking.service;

import isa.projekat.booking.domain.RentACarService;

import java.util.ArrayList;

public interface IRentACarService {

    RentACarService save(RentACarService rentACarService);
    ArrayList<RentACarService> getAll();
    RentACarService findByID(String id);
}
