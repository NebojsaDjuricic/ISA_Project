package isa.projekat.booking.service;

import isa.projekat.booking.domain.Administrator;

public interface IAdministratorService {

    Administrator save(Administrator admin);
    Administrator findById(String id);
}
