package com.philips.AlertToCare.exceptions;

public class BedNotEmptyException extends Exception {
    public BedNotEmptyException() {
        super();
    }
    public BedNotEmptyException(String message) {
        super(message);
    }
}
