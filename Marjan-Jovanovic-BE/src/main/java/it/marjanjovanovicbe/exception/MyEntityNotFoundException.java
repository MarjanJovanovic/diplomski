package it.marjanjovanovicbe.exception;

public class MyEntityNotFoundException extends MyApplicationException {

    public MyEntityNotFoundException(String message) {
        super(message);
    }
}
