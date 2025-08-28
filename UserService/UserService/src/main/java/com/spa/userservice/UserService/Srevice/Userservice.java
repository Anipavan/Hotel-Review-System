package com.spa.userservice.UserService.Srevice;

import org.springframework.stereotype.Service;
import com.spa.userservice.UserService.Entities.user;

import java.util.List;
public interface Userservice {

    //create
    user saveUser(user user);
    //getAll
    List<user> getAllUsers();
    //getsingle
    user getUser(String  userID);
    //Update  TODO
    //delete TODO



}
