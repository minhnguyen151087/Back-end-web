package com.example.web.exception;

public class UserNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(Object resourName){
        super(resourName != null ? resourName.toString() : null );
    }
}
