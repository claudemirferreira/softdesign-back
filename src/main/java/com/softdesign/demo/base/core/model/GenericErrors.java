package com.softdesign.demo.base.core.model;

import org.springframework.http.HttpStatus;

public enum GenericErrors implements IdentifiedError {

    EINT001("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    EINT002("Invalid class mapping", HttpStatus.INTERNAL_SERVER_ERROR),
    EARG001("Missing field on request body", HttpStatus.BAD_REQUEST),
    EARG002("Malformed HTTP Message", HttpStatus.BAD_REQUEST),
    EARG003("Failed to convert parameter", HttpStatus.BAD_REQUEST),
    EAPI001("Not yet implemented", HttpStatus.NOT_IMPLEMENTED);

    private String message;
    private HttpStatus status;

    GenericErrors(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public HttpStatus getStatus() {
        return null;
    }
}
