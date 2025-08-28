package com.spa.Rating.Rating.Repo;

import com.spa.Rating.Rating.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String> {

    List<Rating> findByUserid(String userid);
    List<Rating> findByHotelid(String hotelid);
}
