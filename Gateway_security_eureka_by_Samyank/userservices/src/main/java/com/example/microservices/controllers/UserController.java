package com.example.microservices.controllers;

import com.example.microservices.entities.Hotel;

import com.example.microservices.entities.Rating;
import com.example.microservices.entities.User;
import com.example.microservices.exceptions.ResourceNotFoundExceptions;
import com.example.microservices.external.services.HotelService;
import com.example.microservices.services.UserService;

import com.example.microservices.util.JwtUtil;
import feign.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
     private HotelService hotelService;
    
    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User>  users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword())
        );
        if(!authentication.isAuthenticated()){
            throw new ResourceNotFoundExceptions("Not Authenticated");
        }
        return new ResponseEntity<>(jwtUtil.generateToken(user.getName()),HttpStatus.CREATED);

    }


  //  @CircuitBreaker(name="ratingservice", fallbackMethod="ratingfallback")
    @GetMapping("/{id}")
//    @CircuitBreaker(name="ratingservice", fallbackMethod="ratingfallback")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = userService.getUser(id);
        Rating rating = restTemplate.getForObject("http://RATING/ratings/"+user.getId(),Rating.class);
       // Hotel hotel= hotelService.getHotel(rating.getHotelId());
       // System.out.println(hotel.getName());
       // System.out.println("Hello");
        
        Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/"+rating.getHotelId(),Hotel.class);
        rating.setHotel(hotel);
        user.setRatings(Arrays.asList(rating));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    
//    public ResponseEntity<User> ratingfallback(Long id,Exception ex){
//    	User user = userService.getUser(id);
//
//        // fallback logic
//        user.setRatings(Collections.emptyList());
//
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    
   

}
