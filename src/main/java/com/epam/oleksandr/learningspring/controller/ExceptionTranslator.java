package com.epam.oleksandr.learningspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.epam.oleksandr.learningspring.exception.ApiException;

@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<String> handleException(ApiException apiException){
        return ResponseEntity.status(apiException.getStatusCode()).body(apiException.getMessage());
    }
}