package com.albin.universitySystem.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionDetails {
    private String message;
    private String status ;
    private int statusCode;
}
