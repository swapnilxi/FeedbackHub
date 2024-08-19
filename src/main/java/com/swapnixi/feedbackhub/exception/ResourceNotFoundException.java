package com.swapnixi.feedbackhub.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String field, Object value) {
        super("%s not found with %s : '%s'".formatted(resource, field, value));
    }
}