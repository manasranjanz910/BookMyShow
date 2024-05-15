package dev.manas.BookMyShow.service;

import dev.manas.BookMyShow.exception.InvalidPasswordException;
import dev.manas.BookMyShow.exception.UserNotFoundException;
import dev.manas.BookMyShow.exception.UserWithSameEmailExistsException;
import dev.manas.BookMyShow.model.User;
import dev.manas.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) throws Exception {

        User savedUser = userRepository.findUserByEmail(email);
        if (savedUser == null)
        {
            throw new UserNotFoundException("User with email not exists please signup");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password, savedUser.getPassword()))
        {
            return savedUser;
        }
        throw new InvalidPasswordException("password did not match ");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email, String password) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null){
            throw new UserWithSameEmailExistsException("User with same email exists");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        return  userRepository.save(user);


    }
    public User saveUser(User user )
    {
        return userRepository.save(user);
    }
}
