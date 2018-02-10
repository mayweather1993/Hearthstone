package com.mayweather.hearthstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LOCKED)
public class NotAvailableBoosterException extends RuntimeException {
}
