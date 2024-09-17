package com.atmosware.SuperOnline.GraphQLServer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository
                .findById(id)
                .orElseThrow(null);
    }

    public User createUser(UserRequest userRequest) {
        User user =
                User.builder()
                        .username(userRequest.getUsername())
                        .mail(userRequest.getMail())
                        .build();
        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest) {
        User existing = getUserById(userRequest.getId());
        existing.setUsername(userRequest.getUsername());
        existing.setMail(userRequest.getMail());
        return userRepository.save(existing);
    }

    public void deleteUser(int id) {
        User existing = getUserById(id);
        userRepository.delete(existing);
    }
}
