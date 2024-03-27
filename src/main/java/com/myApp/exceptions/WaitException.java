package com.myApp.exceptions;

public class WaitException extends Exception {
    String message;
    Throwable cause;
    public WaitException(String message, Throwable cause) {
        this.message = getMessage();
        this.cause = getCause();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String toString() {
        return "WaitException{" +
                "message='" + message + '\'' +
                ", cause=" + cause +
                '}';
    }
}
