package com.spa.userservice.UserService.ExternalServices;

import com.spa.userservice.UserService.Entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("ratings/users/{userid}")
    public ArrayList<Rating> getRatings(@PathVariable("userid") String userID);
}
