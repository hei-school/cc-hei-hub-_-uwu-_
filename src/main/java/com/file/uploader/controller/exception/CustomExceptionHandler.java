package com.file.uploader.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.Instant;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException notFoundException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .timestamp(Instant.now())
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
                .timestamp(Instant.now())
                .code(400)
                .status(HttpStatus.BAD_REQUEST)
                .message(badRequestException.getMessage())
                .build();
        return ResponseEntity
                .status(400)
                .body(apiResponse);
    }

    @ExceptionHandler(value = {NotImplementedException.class})
    public ResponseEntity<Object> notImplementedException(NotImplementedException notImplementedException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .timestamp(Instant.now())
                .code(501)
                .status(HttpStatus.NOT_IMPLEMENTED)
                .message(notImplementedException.getMessage())
                .build();
        return ResponseEntity
                .status(501)
                .body(apiResponse);
    }

    @ExceptionHandler(value = {NoResourceFoundException.class})
    public ResponseEntity<Object> noResourceFoundException(NoResourceFoundException noResourceFoundException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .timestamp(Instant.now())
                .code(404)
                .status(HttpStatus.NOT_FOUND)
                .message(noResourceFoundException.getMessage())
                .build();
        return ResponseEntity
                .status(404)
                .body(apiResponse);
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> maxUploadSizeExceededException(MaxUploadSizeExceededException maxUploadSizeExceededException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .timestamp(Instant.now())
                .code(423)
                .status(HttpStatus.LOCKED)
                .message(maxUploadSizeExceededException.getMessage())
                .build();
        return ResponseEntity
                .status(423)
                .body(apiResponse);
    }

    @ExceptionHandler(value = DuplicatedFileException.class)
    public ResponseEntity<Object> duplicatedFile(DuplicatedFileException duplicatedFile) {
        ApiResponse apiResponse = ApiResponse.builder()
                .timestamp(Instant.now())
                .code(100)
                .status(HttpStatus.CONTINUE)
                .message(duplicatedFile.getMessage())
                .build();
        return ResponseEntity
                .status(100)
                .body(apiResponse);
    }
}
