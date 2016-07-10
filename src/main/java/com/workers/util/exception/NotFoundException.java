package com.workers.util.exception;

/**
* db errors exception
*
* @Author Legomin Vitaliy
*/
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
