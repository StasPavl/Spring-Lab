package com.cydeo.lab08rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionWrapper> processNotFoundException(NotFoundException ex){

        //create a json body and return it

        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(ex.getMessage(), HttpStatus.NOT_FOUND);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionWrapper);
    }
}
