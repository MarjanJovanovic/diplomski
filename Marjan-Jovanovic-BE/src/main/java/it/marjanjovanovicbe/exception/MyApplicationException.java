package it.marjanjovanovicbe.exception;

public class MyApplicationException extends RuntimeException{

    public MyApplicationException(String message) {
        super(message);
    }
}
