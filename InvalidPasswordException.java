package com.company;

public class InvalidPasswordException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid username or password!";
    }
}
