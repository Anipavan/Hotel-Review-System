package com.spa.Rating.Rating.Services;

import com.spa.Rating.Rating.Entity.Rating;

import java.util.List;

public interface RatingService {
    // Create
    Rating createRating(Rating rating);

    // GetAlll
    List<Rating> getAllRatings();

    // GetBYHotelID
   List<Rating> getRatingByHotelID(String hotelId);

    //GetBY UserID.
   List<Rating> getRatingByUserID(String userId);



}
