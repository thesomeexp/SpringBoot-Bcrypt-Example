package com.someexp.exception;

public class UsernameExistsException extends RuntimeException{

    public UsernameExistsException() {
        super();
    }

    public UsernameExistsException(String msg){
        super(msg);
    }
}
