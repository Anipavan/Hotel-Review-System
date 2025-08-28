package com.spa.Rating.Rating.Services.Impul;

import com.spa.Rating.Rating.Entity.Rating;
import com.spa.Rating.Rating.Repo.RatingRepo;
import com.spa.Rating.Rating.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpul implements RatingService {
    @Autowired
    RatingRepo ratingrepo;
    @Override
    public Rating createRating(Rating rating) {
        String randomid= UUID.randomUUID().toString();
        rating.setRatingid(randomid);
        return ratingrepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {

        return ratingrepo.findAll();
    }
    @Override
    public List<Rating> getRatingByHotelID(String hotelId) {

        return ratingrepo.findByHotelid(hotelId);
    }

    @Override
    public List<Rating> getRatingByUserID(String userId) {

        return ratingrepo.findByUserid(userId);
    }
}
