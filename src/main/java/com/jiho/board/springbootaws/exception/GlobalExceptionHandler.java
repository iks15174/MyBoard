package com.jiho.board.springbootaws.exception;

import com.jiho.board.springbootaws.exception.exceptions.CustomBasicException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomBasicException.class)
    protected ResponseEntity<ErrorResponse> handleCustomBasicException(CustomBasicException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, e.changeToHttpStatus());
    }
}
