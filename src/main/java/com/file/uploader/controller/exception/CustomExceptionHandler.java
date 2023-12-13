package com.file.uploader.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException notFoundException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(404)
                .status(HttpStatus.NOT_FOUND)
                .message(notFoundException.getMessage())
                .build();
        return ResponseEntity
                .status(404)
                .body(apiResponse);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> badRequestExceptionHandler(BadRequestException badRequestException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(400)
                .status(HttpStatus.BAD_REQUEST)
                .message(badRequestException.getMessage())
                .build();
        return ResponseEntity
                .status(400)
                .body(apiResponse);
    }

    @ExceptionHandler(value = {NoResourceFoundException.class})
    public ResponseEntity<Object> noResourceFoundException(NoResourceFoundException noResourceFoundException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(404)
                .status(HttpStatus.NOT_FOUND)
                .message(noResourceFoundException.getMessage())
                .build();
        return ResponseEntity
                .status(404)
                .body(apiResponse);
    }
}
