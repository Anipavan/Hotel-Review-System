package com.spa.userservice.UserService.ExternalServices;

import com.spa.userservice.UserService.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("hotel/{hotelid}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelid") String hotelID);

}
