package com.atmosware.SuperOnline.GraphQLServer;


import lombok.Data;

@Data
public class UserRequest {
    private int id;
    private String username;
    private String mail;
}
