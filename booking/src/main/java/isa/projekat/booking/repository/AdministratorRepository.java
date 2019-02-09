package isa.projekat.booking.repository;

import isa.projekat.booking.domain.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends MongoRepository<Administrator, String> {
}
