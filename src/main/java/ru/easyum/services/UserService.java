package ru.easyum.services;

import org.springframework.stereotype.Service;
import ru.easyum.model.User;
import ru.easyum.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Random random = new Random();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findRandomUser() {
        List<User> users = findAll();

        if (users.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(users.get(random.nextInt(users.size())));
    }
}