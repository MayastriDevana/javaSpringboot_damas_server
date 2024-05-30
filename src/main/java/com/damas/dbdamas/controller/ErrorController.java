package com.damas.dbdamas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.damas.dbdamas.payload.WebResponse;


@RestControllerAdvice// untuk identifikasi untuk custopm error
public class ErrorController {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<WebResponse<String>> responseStatusException(ResponseStatusException exception) {
        // WebResponse<String> response = new WebResponse<>();
        // response.setData(null);
        // response.setErrors(exception.getReason());
        // return ResponseEntity.status(exception.getStatusCode().)
        return ResponseEntity
        .status(exception.getStatusCode())
        .body(WebResponse.<String>builder().error(exception.getReason())
        .build());
    }
}
