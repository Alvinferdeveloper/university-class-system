package com.albin.universitySystem.DTOs.Response;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class AlumnoResponse {
    private long id;
    private Date birthDay;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String dni;
    private CarreraResponse carrera;
}
