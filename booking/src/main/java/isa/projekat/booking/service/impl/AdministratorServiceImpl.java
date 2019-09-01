package isa.projekat.booking.service.impl;

import isa.projekat.booking.domain.Administrator;
import isa.projekat.booking.repository.AdministratorRepository;
import isa.projekat.booking.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements IAdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    @Override
    public Administrator save(Administrator admin) {
        return administratorRepository.save(admin);
    }

	@Override
	public ArrayList<Administrator> getAll() {
		List<Administrator> administrators = administratorRepository.findAll();
		
		return (ArrayList<Administrator>) administrators;
	}
    
    @Override
    public Administrator findById(String id) {

        Optional<Administrator> queryResult = administratorRepository.findById(id);

        if(queryResult.isPresent()) {
            return queryResult.get();
        }
        else {
            return null;
        }
    }

	@Override
	public Administrator deleteAdmin(String id) {
		Administrator administrator = findById(id);
		administratorRepository.delete(administrator);
		
		return administrator;
	}

}
