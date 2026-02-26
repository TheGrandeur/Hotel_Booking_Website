package com.example.Rating.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rating.entity.Rating;
import com.example.Rating.service.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public Rating create(@RequestBody Rating  rating) {
		return ratingService.save(rating);
	}
	
	@GetMapping
	public List<Rating> getAll(){
		return ratingService.getAll();
	}
	
	@GetMapping("/{id}")
	public Rating getById(@PathVariable Long id) {
		return ratingService.getById(id);
	}

}
