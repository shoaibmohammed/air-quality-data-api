package com.shoaib.airqualitydataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data not found")

public class DataNotFoundException extends RuntimeException {
}
