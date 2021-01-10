package com.soapexample.endpoint;

import com.soapexample.webservice.GetUserRequest;
import com.soapexample.webservice.GetUserResponse;
import com.soapexample.webservice.User;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://soapexample.com/webService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getCountry(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        User user = new User();
        user.setName(request.getName());
        user.setEmpId(11);
        user.setSalary(1000.0);
        response.setUser(user);
        return response;
    }

}
