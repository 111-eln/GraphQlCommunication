package com.atmosware.SuperOnline.GraphQLClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private int id;
    private String username;
    private String mail;
}
