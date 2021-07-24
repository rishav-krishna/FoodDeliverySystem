package com.rishav.exception;

public class NoRestaurantCanFulfillOrder extends RuntimeException{
    private String message;

    public NoRestaurantCanFulfillOrder(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
