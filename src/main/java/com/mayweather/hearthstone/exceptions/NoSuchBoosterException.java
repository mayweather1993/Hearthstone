package com.mayweather.hearthstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchBoosterException extends RuntimeException {
    public NoSuchBoosterException(String message) {
        super(message);
    }
}
