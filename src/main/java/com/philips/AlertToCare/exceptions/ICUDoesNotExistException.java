package com.philips.AlertToCare.exceptions;

public class ICUDoesNotExistException extends Exception {

    public ICUDoesNotExistException() {
        super();
    }

    public ICUDoesNotExistException(String message) {
        super(message);
    }
}