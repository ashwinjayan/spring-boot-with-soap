package com.springsoapexample.service;

import com.springsoapexample.soapexample.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {
        User peter = new User();
        peter.setEmpId(112);
        peter.setName("Peter");
        peter.setSalary(12000.0);

        User sam = new User();
        sam.setEmpId(111);
        sam.setName("Sam");
        sam.setSalary(22000.0);

        User ryan = new User();
        ryan.setEmpId(113);
        ryan.setName("Ryan");
        ryan.setSalary(15000.0);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);
    }

    public User getUsers(String name) {
        return users.get(name);
    }
}
