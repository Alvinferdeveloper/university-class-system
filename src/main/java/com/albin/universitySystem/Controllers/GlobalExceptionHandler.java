package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.Exceptions.ExceptionDetails;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDetails(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),"INVALID DATA",HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity<ExceptionDetails> handleNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDetails(ex.getMessage(),"NOT FOUND",HttpStatus.NOT_FOUND.value()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleAppExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDetails(ex.getMessage(),"INTERNAL ERROR",HttpStatus.INTERNAL_SERVER_ERROR.INTERNAL_SERVER_ERROR.value()));
    }
}
