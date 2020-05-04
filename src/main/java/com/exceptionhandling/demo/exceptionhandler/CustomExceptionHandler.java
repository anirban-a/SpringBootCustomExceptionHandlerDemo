package com.exceptionhandling.demo.exceptionhandler;

import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
  Logger log = Logger.getLogger(getClass());

  @ExceptionHandler(MyException.class)
  public ResponseEntity<ErrorResponse> handler(Exception ex, WebRequest request)
      throws IOException {
    log.debug("Inside exception handler");

    ErrorResponse error = new ErrorResponse();
    error.setTimeStamp(LocalDateTime.now());
    error.setErrorMessage(ex.getLocalizedMessage());
    error.setStatusCode(HttpStatus.BAD_REQUEST.toString());

    return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
  }
}
