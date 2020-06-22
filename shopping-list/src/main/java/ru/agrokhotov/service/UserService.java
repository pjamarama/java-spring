package ru.agrokhotov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.agrokhotov.persist.User;
import ru.agrokhotov.persist.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void create (UserRepresentation userRepresentation) {
        User user = new User();
        user.setUsername(userRepresentation.getUsername());
        user.setPassword(encoder.encode(userRepresentation.getPassword()));
        repository.save(user);
    }
}
