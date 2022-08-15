package it.engineering.marjanjovanovicbe.exception;

import it.engineering.marjanjovanovicbe.dto.MyDto;

public class MyEntityAlreadyExistsException extends MyApplicationException{

    private final MyDto entity;

    public MyEntityAlreadyExistsException(String message, MyDto entity) {
        super(message);
        this.entity = entity;
    }

    public Object getEntity(){
        return entity;
    }
}
