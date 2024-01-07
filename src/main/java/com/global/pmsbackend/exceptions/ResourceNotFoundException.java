package com.global.pmsbackend.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final int statusCode;

    public ResourceNotFoundException(int statusCode, String message) {

        super(message);

        this.statusCode = statusCode;

    }

}
