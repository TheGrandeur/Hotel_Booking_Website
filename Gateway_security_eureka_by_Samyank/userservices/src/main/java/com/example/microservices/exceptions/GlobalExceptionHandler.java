package com.example.microservices.exceptions;

import com.example.microservices.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExceptions.class)
     public ResponseEntity<?> handleException(ResourceNotFoundExceptions ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
