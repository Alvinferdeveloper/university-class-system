package com.albin.universitySystem.DTOs.Response;

import com.albin.universitySystem.Enums.Authority;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class ProfesorResponse {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private String dni;
    List<Authority> authorities;
    RoleResponse role;
}
