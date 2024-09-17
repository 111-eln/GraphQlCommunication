package com.atmosware.SuperOnline.GraphQLClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

@Component

public class UserClient {
    @Autowired
    private HttpGraphQlClient graphQlClient;
    public User createUser(UserRequest itemRequest) {
        String graphQlQuery = String.format(
                "mutation {" +
                        " createUser(userRequest: {" +
                        " id: %d," +
                        " username: \"%s\"," +
                        " mail: \"%s\"" +
                        " }) {" +
                        " username" +
                        " }" +
                        "}", itemRequest.getId(), itemRequest.getUsername(), itemRequest.getMail());;
        return graphQlClient.document(graphQlQuery)
                .retrieve("createUser")
                .toEntity(User.class).block();
    }

}
