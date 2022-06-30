package com.publicis.sapient.creditcardprocessing.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> invalidCardException(RuntimeException ex){
        var body = new HashMap<String, Object>();
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, NOT_ACCEPTABLE);
    }

}
