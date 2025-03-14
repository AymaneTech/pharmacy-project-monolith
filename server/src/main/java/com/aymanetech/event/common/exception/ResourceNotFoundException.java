package com.aymanetech.event.common.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entity, Long id) {
        super(entity + " with id " + id + " not found");
    }

    public ResourceNotFoundException(String entity, Integer id) {
        super(entity + " with id " + id + " not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
