package com.codeWithAjay.fullStackBackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id){
        super("could not found user with id:"+id);
    }

}
