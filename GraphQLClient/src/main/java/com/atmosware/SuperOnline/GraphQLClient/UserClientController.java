package com.atmosware.SuperOnline.GraphQLClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserClientController {
    @Autowired
    public MyService myService;
    @PostMapping
    public User createUser(@RequestBody UserRequest createUserRequest) {
        return myService.createUser(createUserRequest);
    }
}
