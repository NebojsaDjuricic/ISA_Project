package isa.projekat.booking.service.impl;

import isa.projekat.booking.domain.RentACarService;
import isa.projekat.booking.repository.RentACarServiceRepository;
import isa.projekat.booking.service.IRentACarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentACarServiceImpl implements IRentACarService {

    @Autowired
    RentACarServiceRepository rentACarServiceRepository;

    @Override
    public RentACarService save(RentACarService rentACarService) {
        return rentACarServiceRepository.save(rentACarService);
    }

    @Override
    public ArrayList<RentACarService> getAll() {
        List<RentACarService> retVal = rentACarServiceRepository.findAll();

        return (ArrayList<RentACarService>) retVal;
    }

    @Override
    public RentACarService findByID(String id) {
        RentACarService retVal;
        Optional<RentACarService> byId = rentACarServiceRepository.findById(id);
        retVal = byId.get();

        return retVal;
    }

	@Override
	public List<RentACarService> findByName(String queryInput) {
		// TODO Auto-generated method stub
		
		List<RentACarService> byName = rentACarServiceRepository.findByName(queryInput);
		
		return byName;
	}
}
