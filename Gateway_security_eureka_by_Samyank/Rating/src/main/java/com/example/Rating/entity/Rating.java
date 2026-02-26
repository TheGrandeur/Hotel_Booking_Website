package com.example.Rating.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
   @Id
   private ObjectId id;
   private Long userId;
   private Long hotelId;
   private  int rating;
   private  String feedback;
   
}
