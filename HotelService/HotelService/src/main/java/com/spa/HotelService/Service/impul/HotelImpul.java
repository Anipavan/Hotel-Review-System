package com.spa.HotelService.Service.impul;

import com.spa.HotelService.Entities.Hotel;
import com.spa.HotelService.Exception.ResourceNotFoudException;
import com.spa.HotelService.Repositeries.HotelRepo;
import com.spa.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelImpul implements HotelService {
    @Autowired
    HotelRepo hotelrepo;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomid= UUID.randomUUID().toString();
        hotel.setHotelID(randomid);
        return hotelrepo.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelid) {
        return hotelrepo.findById(hotelid).orElseThrow(()->new ResourceNotFoudException("Hotel details with the given ID is not present in the database"+hotelid));
    }
    @Override
    public List<Hotel> getAllHotels() {
        return hotelrepo.findAll();
    }
}
