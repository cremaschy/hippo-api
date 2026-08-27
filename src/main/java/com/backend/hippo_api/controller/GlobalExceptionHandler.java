package com.backend.hippo_api.controller;

import com.backend.hippo_api.infrastructure.exceptions.ConflictException;
import com.backend.hippo_api.infrastructure.exceptions.ResourceNotFoundException;
import com.backend.hippo_api.infrastructure.records.ErrorResponseRecord;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Tratar uma ConflicException
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseRecord> handleConflictException(ConflictException e) {

        ErrorResponseRecord erro = new ErrorResponseRecord(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(erro);
    }

    // Tratar uma BadCredentialsException
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseRecord> handleBadCredentialsException(BadCredentialsException e) {

        ErrorResponseRecord erro = new ErrorResponseRecord(
                HttpStatus.UNAUTHORIZED.value(),
                "E-mail ou Senha Inválidos",
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(erro);
    }

    // Tratar uma ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseRecord> handleResourceNotFoundException(ResourceNotFoundException e) {

        ErrorResponseRecord erro = new ErrorResponseRecord(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erro);
    }
}
