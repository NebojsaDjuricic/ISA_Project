package isa.projekat.booking.service;

import isa.projekat.booking.domain.User;

public interface IUserService {

    User save(User user);
    User findByEmail(String email);
}
