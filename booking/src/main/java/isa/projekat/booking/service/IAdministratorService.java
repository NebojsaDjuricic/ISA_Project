package isa.projekat.booking.service;

import java.util.ArrayList;

import isa.projekat.booking.domain.Administrator;

public interface IAdministratorService {

    Administrator save(Administrator admin);
    Administrator findById(String id);
    Administrator deleteAdmin(String id);
    ArrayList<Administrator> getAll();
    
}
