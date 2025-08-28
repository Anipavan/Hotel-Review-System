package com.spa.HotelService.Service;

import com.spa.HotelService.Entities.Hotel;

import java.util.List;

public interface HotelService {

    //Create
    Hotel saveHotel(Hotel hotel);
    //get Single
    Hotel getHotel(String hotelid);
    //getAll
    List<Hotel> getAllHotels();
}
