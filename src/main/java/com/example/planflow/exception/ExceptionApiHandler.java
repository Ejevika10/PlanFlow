package com.example.planflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(NotFoundException exception) {
        return new ResponseEntity<>(new ErrorMessage(exception.getErrorCode(), exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> defException(Exception exception) {
        return new ResponseEntity<>(new ErrorMessage(500L, exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
