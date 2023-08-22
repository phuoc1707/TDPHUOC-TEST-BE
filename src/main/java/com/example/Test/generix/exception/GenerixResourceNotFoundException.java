package com.example.Test.generix.exception;

public class GenerixResourceNotFoundException extends RuntimeException {

    public GenerixResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
    }

}
