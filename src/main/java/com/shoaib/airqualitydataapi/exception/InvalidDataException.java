package com.shoaib.airqualitydataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Data")
public class InvalidDataException extends RuntimeException {
}
