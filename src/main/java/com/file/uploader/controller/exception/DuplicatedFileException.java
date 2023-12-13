package com.file.uploader.controller.exception;

public class DuplicatedFileException extends RuntimeException {
  public DuplicatedFileException() {}

  public DuplicatedFileException(String message) {
    super(message);
  }

  public DuplicatedFileException(String message, Throwable cause) {
    super(message, cause);
  }

  public DuplicatedFileException(Throwable cause) {
    super(cause);
  }

  public DuplicatedFileException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
