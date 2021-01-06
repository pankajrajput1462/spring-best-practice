package com.example.springbootlearn.expection;

public class DataNotFound extends RuntimeException {
    public DataNotFound() {
    }

    public DataNotFound(String message) {
        super(message);
    }
}
