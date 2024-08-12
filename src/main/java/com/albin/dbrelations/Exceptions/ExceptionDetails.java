package com.albin.dbrelations.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionDetails {
    private String message;
    private String status ;
    private int statusCode;
}
