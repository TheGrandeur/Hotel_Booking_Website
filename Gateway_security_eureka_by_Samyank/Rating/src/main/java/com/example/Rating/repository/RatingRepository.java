package com.example.Rating.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Rating.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating,ObjectId>{
  Rating findByUserId(Long id);
}
