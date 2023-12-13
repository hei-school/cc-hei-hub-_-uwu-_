package com.file.uploader.controller.exception;

import java.time.Instant;

import jakarta.persistence.QueryTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
  @ExceptionHandler(value = {NotFoundException.class})
  public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException exception) {
    ApiResponse apiResponse =
        ApiResponse.builder()
            .timestamp(Instant.now())
            .code(404)
            .status(HttpStatus.NOT_FOUND.toString())
            .message(exception.getMessage())
            .build();
    return ResponseEntity.status(404).body(apiResponse);
  }

  @ExceptionHandler(value = {NoResourceFoundException.class})
  public ResponseEntity<Object> noResourceFoundException(NoResourceFoundException exception) {
    ApiResponse apiResponse =
            ApiResponse.builder()
                    .timestamp(Instant.now())
                    .code(404)
                    .status(HttpStatus.NOT_FOUND.toString())
                    .message(exception.getMessage())
                    .build();
    return ResponseEntity.status(404).body(apiResponse);
  }

  @ExceptionHandler(value = {FileNotFoundException.class})
  public ResponseEntity<Object> fileNotFoundExceptionHandler(FileNotFoundException exception) {
    ApiResponse apiResponse =
            ApiResponse.builder()
                    .timestamp(Instant.now())
                    .code(404)
                    .status(CustomHttpStatus.FILE_NOT_FOUND.toString())
                    .message(exception.getMessage())
                    .build();
    return ResponseEntity.status(404).body(apiResponse);
  }

  @ExceptionHandler(value = {BadRequestException.class})
  public ResponseEntity<Object> badRequestExceptionHandler(
      BadRequestException badRequestException) {
    ApiResponse apiResponse =
        ApiResponse.builder()
            .timestamp(Instant.now())
            .code(400)
            .status(HttpStatus.BAD_REQUEST.toString())
            .message(badRequestException.getMessage())
            .build();
    return ResponseEntity.status(400).body(apiResponse);
  }

  @ExceptionHandler(value = {NotImplementedException.class})
  public ResponseEntity<Object> notImplementedException(
      NotImplementedException notImplementedException) {
    ApiResponse apiResponse =
        ApiResponse.builder()
            .timestamp(Instant.now())
            .code(501)
            .status(HttpStatus.NOT_IMPLEMENTED.toString())
            .message(notImplementedException.getMessage())
            .build();
    return ResponseEntity.status(501).body(apiResponse);
  }

  @ExceptionHandler(value = MaxUploadSizeExceededException.class)
  public ResponseEntity<Object> maxUploadSizeExceededException(
      MaxUploadSizeExceededException maxUploadSizeExceededException) {
    ApiResponse apiResponse =
        ApiResponse.builder()
            .timestamp(Instant.now())
            .code(423)
            .status(CustomHttpStatus.FILE_TOO_LARGE.toString())
            .message(maxUploadSizeExceededException.getMessage())
            .build();
    return ResponseEntity.status(423).body(apiResponse);
  }

  @ExceptionHandler(value = DuplicatedFileException.class)
  public ResponseEntity<Object> duplicatedFile(DuplicatedFileException duplicatedFile) {
    ApiResponse apiResponse =
        ApiResponse.builder()
            .timestamp(Instant.now())
            .code(100)
            .status(CustomHttpStatus.DUPLICATE_FILE.toString())
            .message(duplicatedFile.getMessage())
            .build();
    return ResponseEntity.status(100).body(apiResponse);
  }

  @ExceptionHandler(value = QueryTimeoutException.class)
  public ResponseEntity<Object> queryTimeOutException(QueryTimeoutException queryTimeoutException) {
    ApiResponse apiResponse =
            ApiResponse.builder()
                    .timestamp(Instant.now())
                    .code(408)
                    .status(HttpStatus.REQUEST_TIMEOUT.toString())
                    .message(queryTimeoutException.getMessage())
                    .build();
    return ResponseEntity.status(408).body(apiResponse);
  }
}
