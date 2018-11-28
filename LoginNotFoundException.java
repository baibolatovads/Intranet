package com.company;

public class LoginNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Such login doesn't exist!";
    }
}
