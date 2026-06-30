package com.user.service.exceptions;

import com.user.service.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> UserNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(100, Boolean.FALSE.toString(), message);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
