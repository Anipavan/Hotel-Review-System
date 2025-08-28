package com.spa.userservice.UserService.Entities;
;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
  private String ratingid;
  private  String userid;
  private  String hotelid;
  private  int rating;
  private  String feedback;
  private  Hotel hotel;

}
