package com.netcracker.theater.rtickets.exception;

public class BadRequestException extends ResourceNotFoundException {

    public BadRequestException(String msg)
    {
        super(msg);
    }
}
