package com.spa.userservice.UserService.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "UserDetails")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class user {
    @Id
    public  String userid;
    public  String  username;
    public  String email;
    public  String  about;

    @Transient
    private List<Rating> ratings;



}
