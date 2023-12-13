package com.file.uploader.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ApiResponse {
    private Instant timestamp;
    private Integer code;
    private HttpStatus status;
    private String message;
}
