package com.aymanetech.pharmacy.common.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource with id " + id + " not found");
    }
}
