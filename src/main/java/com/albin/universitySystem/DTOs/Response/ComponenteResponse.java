package com.albin.universitySystem.DTOs.Response;
import com.albin.universitySystem.Enums.Semester;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComponenteResponse {
    long id;
    String name;
    int owner_year;
    Semester semester;
}
