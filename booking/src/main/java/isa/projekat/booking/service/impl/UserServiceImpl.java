package isa.projekat.booking.service.impl;

import isa.projekat.booking.domain.User;
import isa.projekat.booking.repository.UserRepository;
import isa.projekat.booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {

        Optional<User> queryResult = userRepository.findById(email);


        if(queryResult.isPresent()) {
            return queryResult.get();
        }
        else {
            return null;
        }
    }
}
