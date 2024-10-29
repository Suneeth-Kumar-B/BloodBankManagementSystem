package com.hcl.app.exception;


public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("Username already exists!!!");
    }
}
