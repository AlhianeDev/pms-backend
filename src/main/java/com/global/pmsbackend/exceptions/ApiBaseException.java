package com.global.pmsbackend.exceptions;

public abstract class ApiBaseException extends RuntimeException {

    public ApiBaseException(String message) {

        super(message);

    }

}
