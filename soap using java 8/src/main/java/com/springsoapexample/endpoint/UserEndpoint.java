package com.springsoapexample.endpoint;

import com.springsoapexample.service.UserService;
import com.springsoapexample.soapexample.UserRequest;
import com.springsoapexample.soapexample.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://springsoapexample.com/soapexample",
        localPart = "UserRequest")
    @ResponsePayload
    public UserResponse getUserRequest(@RequestPayload UserRequest req) {
        UserResponse response = new UserResponse();
        response.setUser(userService.getUsers(req.getName()));
        return response;
    }

}
