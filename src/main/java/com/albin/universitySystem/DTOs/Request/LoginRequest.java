package com.albin.universitySystem.DTOs.Request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
