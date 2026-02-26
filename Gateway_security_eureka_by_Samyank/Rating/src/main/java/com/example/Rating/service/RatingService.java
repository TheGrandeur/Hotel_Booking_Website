package com.example.Rating.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Rating.entity.Rating;
import com.example.Rating.repository.RatingRepository;

@Service
public class RatingService {
   @Autowired
   private RatingRepository ratingRepository;
   
   public Rating save(Rating rating) {
	   return ratingRepository.save(rating);
   }
   
   
   public List<Rating> getAll(){
	   return ratingRepository.findAll();
   }
   
   public Rating getById(Long id){
	   return ratingRepository.findByUserId(id);
   }
}
