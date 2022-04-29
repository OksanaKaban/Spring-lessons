package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomerRestExceptionHandler {
    // add exceptionHandler for 'customer not found' exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {

        // Create customer error response
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        // Return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exceptionHandler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handledException(Exception exception) {
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
               "Invalid symbol for customer Id",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
