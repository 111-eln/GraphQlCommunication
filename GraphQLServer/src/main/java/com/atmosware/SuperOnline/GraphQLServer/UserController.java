package com.atmosware.SuperOnline.GraphQLServer;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

//    public UserController(UserService userService) {
//        this.userRepository = userService;
//    }

//    @QueryMapping("/graphiql")
//    List<User> getAllUsers() {
//        return userRepository.findAll();
//    }

    @QueryMapping
    User getUserById(@Argument("id") int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("bulunamadi"));
    }

    @MutationMapping
    User createUser(@Argument("userRequest") User userRequest) {
        return userRepository.save(userRequest);
    }

//    @MutationMapping
//    User updateUser(@Argument UserRequest userRequest) {
//        return userRepository.updateUser(userRequest);
//    }
//
//    @MutationMapping
//    Boolean deleteUser(@Argument int id) {
//        userRepository.deleteUser(id);
//        return true;
//    }
}
