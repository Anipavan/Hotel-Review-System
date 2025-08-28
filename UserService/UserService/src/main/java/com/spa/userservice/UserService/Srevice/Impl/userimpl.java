package com.spa.userservice.UserService.Srevice.Impl;
import com.spa.userservice.UserService.Entities.Hotel;
import com.spa.userservice.UserService.Entities.Rating;
import com.spa.userservice.UserService.Entities.user;
import com.spa.userservice.UserService.Exceptions.ResourceNotFoundException;
import com.spa.userservice.UserService.ExternalServices.HotelService;
import com.spa.userservice.UserService.ExternalServices.RatingService;
import com.spa.userservice.UserService.Repo.Userrepo;
import com.spa.userservice.UserService.Srevice.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class userimpl implements Userservice {
    @Autowired
    Userrepo userrepo;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HotelService hexservice;
    @Autowired
    RatingService rexservice;
    @Override
    public user saveUser(user user) {
       String randomuuserid= UUID.randomUUID().toString();
       user.setUserid(randomuuserid);
        return userrepo.save(user);
    }

    @Override
    public List<user> getAllUsers() {

       ArrayList<user> Allusers= (ArrayList<user>) userrepo.findAll();
       for(user u: Allusers)
       {
           //  **********  Calling external service using Rest Template.  **********
          // ArrayList ratings= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+u.getUserid(), ArrayList.class);

           //  **********  Calling external service using Feign Client   **********
           ArrayList<Rating> ratings=rexservice.getRatings(u.getUserid());
           u.setRatings(ratings);
       }
        return Allusers;

    }

    @Override
    public user getUser(String userID) {
        user user = userrepo.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Record with the given userid is not present in the database :" + userID));

        // get ratings of this user
        //  **********  Calling external service using Rest Template.  **********
        //Rating[] ratingsofUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserid(),Rating[].class);

        //  **********  Calling external service using Feign Client   **********
        ArrayList<Rating> ratingsofUser = rexservice.getRatings(user.getUserid());

        List<Rating> ratinglist = ratingsofUser.stream().map(rating -> {
            //  **********  Calling external service using Rest Template.  **********
            //ResponseEntity<com.spa.userservice.UserService.Entities.Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelid(), com.spa.userservice.UserService.Entities.Hotel.class);

            //  **********  Calling external service using Feign Client   **********
            Hotel hotel = hexservice.getHotel(rating.getHotelid()).getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratinglist);
        return user;
    }
}
