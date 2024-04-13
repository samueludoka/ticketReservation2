package org.smartapplication.exception;

public class InvalidDetailsException extends RuntimeException {
    public InvalidDetailsException(){

        super("invalid username or password");
    }
}
