package com.mircoservices.HotelService.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {
    public ResourceNotFoundExceptions(String s) {
        super(s);
    }

    public ResourceNotFoundExceptions(){
        super("Resource not found !!");
    }
}
