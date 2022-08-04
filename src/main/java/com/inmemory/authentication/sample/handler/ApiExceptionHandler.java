package com.inmemory.authentication.sample.handler;

import com.inmemory.authentication.sample.exception.ApiException;
import com.inmemory.authentication.sample.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(ProductNotFoundException e) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}