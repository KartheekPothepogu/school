package com.ex.Exception;

import com.ex.Payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> resourceHandler(ResourceNotFound resourceNotFound)
    {
        ErrorDetails errorDetails=new ErrorDetails(resourceNotFound.getMessage(),new Date());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalHandler(Exception exception)
    {
        ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(),new Date());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }




}
