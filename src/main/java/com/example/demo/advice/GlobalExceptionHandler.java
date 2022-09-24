package com.example.demo.advice;

import com.example.demo.exception.InputValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ RuntimeException.class, InputValidationException.class })
    public final ResponseEntity<String> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof InputValidationException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(ex.getMessage(), headers, status);
        }
        else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>("Unexpected error occurred. Try again later.", headers, status);
        }
    }

}
