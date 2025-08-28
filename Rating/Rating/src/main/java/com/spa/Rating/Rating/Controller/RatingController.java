package com.spa.Rating.Rating.Controller;

import com.spa.Rating.Rating.Entity.Rating;
import com.spa.Rating.Rating.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService service;
    @PostMapping
    public ResponseEntity<Rating> Create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
    }
    @GetMapping
public ResponseEntity<List<Rating>> getAllRatings()
{
    return  ResponseEntity.ok(service.getAllRatings());
}
@GetMapping("/users/{userId}")
public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
{
    return  ResponseEntity.ok(service.getRatingByUserID(userId));
}
@GetMapping("/hotel/{hotelId}")
public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
{
    return  ResponseEntity.ok(service.getRatingByHotelID(hotelId));
}


}
