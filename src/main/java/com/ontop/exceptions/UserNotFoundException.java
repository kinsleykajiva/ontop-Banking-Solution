package com.ontop.exceptions;

public class UserNotFoundException  extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}