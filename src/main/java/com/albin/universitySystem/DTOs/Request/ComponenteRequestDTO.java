package com.albin.universitySystem.DTOs.Request;

import com.albin.universitySystem.DTOs.GroupDTO;
import com.albin.universitySystem.Enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComponenteRequestDTO {
    private long id;
    private String name;
    private int owner_year;
    Semester semester;
}