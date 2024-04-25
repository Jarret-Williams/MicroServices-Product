package com.example.Microservices.exceptions.BAD_REQ;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class NameTakenExceptionHandler {

    @ExceptionHandler(value = {NameTakenRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(NameTakenRequestException e){
        //1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        NameTakenException apiException = new NameTakenException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //2. Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
