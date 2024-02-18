package com.lcwd.user.service.userservice.exceptions;

import com.lcwd.user.service.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(UserNotFoundException ex)
    {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder()
                .message(message).httpStatus(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}
