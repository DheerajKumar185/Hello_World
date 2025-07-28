package com.tech.spring.boot.docker.exception;

import com.tech.spring.boot.docker.util.SystemDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRecordNotFound(RecordNotFoundException message) {
        ErrorResponse response = new ErrorResponse(SystemDateTime.getDateTime(), HttpStatus.NOT_FOUND.value(),
                "Record not found", message.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(SystemDateTime.getDateTime(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An error occurred", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
