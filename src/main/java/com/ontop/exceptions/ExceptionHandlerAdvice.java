package com.ontop.exceptions;

public class ExceptionHandlerAdvice extends RuntimeException {

    public ExceptionHandlerAdvice(String message) {
        super(message);
    }

}
