package com.atmosware.SuperOnline.GraphQLClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    public UserClient userClient;
    public User createUser(UserRequest itemRequest) {
        return userClient.createUser(itemRequest);
    }

}

