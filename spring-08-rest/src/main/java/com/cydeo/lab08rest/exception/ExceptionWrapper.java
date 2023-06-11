package com.cydeo.lab08rest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ExceptionWrapper {
    public String message;
    public HttpStatus httpStatus;

    public ExceptionWrapper(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
