package com.Ducat.SpringFirstProject.Exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message){
        super(message);
    }
}
