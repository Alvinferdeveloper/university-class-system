package com.albin.universitySystem.DTOs.Request;

import com.albin.universitySystem.Enums.Semester;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupRequest {
    private long profesorId;
    private long componenteId;
    private Semester semester;
    private Integer year;
}
