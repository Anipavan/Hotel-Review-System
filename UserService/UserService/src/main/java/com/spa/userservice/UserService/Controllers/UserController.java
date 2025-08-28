package com.spa.userservice.UserService.Controllers;

import com.spa.userservice.UserService.Entities.user;
import com.spa.userservice.UserService.Srevice.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
   private Userservice uservice;
    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody user user)
    {
        user u1=uservice.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(u1);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<user> getSingleUser( @PathVariable String userid)
    {
       user User= uservice.getUser(userid);
        return  ResponseEntity.ok(User);
    }

    @GetMapping
    public ResponseEntity<List<user>> getAllUsers()
    {
        List<user> allusers=uservice.getAllUsers();
        return  ResponseEntity.ok(allusers);
    }


}
