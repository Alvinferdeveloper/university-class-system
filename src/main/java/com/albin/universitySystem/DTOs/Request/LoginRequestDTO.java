package com.albin.universitySystem.DTOs.Request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
