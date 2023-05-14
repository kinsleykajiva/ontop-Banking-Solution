package com.ontop.exceptions;

public class BankDetailsNotFoundException   extends RuntimeException {

    public BankDetailsNotFoundException(String message) {
        super(message);
    }

}
