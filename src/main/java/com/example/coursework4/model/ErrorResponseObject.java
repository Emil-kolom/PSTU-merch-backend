package com.example.coursework4.model;

public class ErrorResponseObject {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponseObject(String message) {
        this.message = message;
    }

    public ErrorResponseObject() {
    }


}
