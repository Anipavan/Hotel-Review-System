package com.spa.HotelService.Controller;

import com.spa.HotelService.Entities.Hotel;
import com.spa.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelservice;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel H1=hotelservice.saveHotel(hotel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(H1);
    }

    @GetMapping("/{hotelid1}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelid1") String hotelid)
    {
        return  ResponseEntity.ok(hotelservice.getHotel(hotelid));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {

        return  ResponseEntity.ok(hotelservice.getAllHotels());
    }
}
