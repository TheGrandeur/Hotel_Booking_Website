package com.mircoservices.HotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mircoservices.HotelService.payload.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExceptions.class)
     public ResponseEntity<?> handleException(ResourceNotFoundExceptions ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}

