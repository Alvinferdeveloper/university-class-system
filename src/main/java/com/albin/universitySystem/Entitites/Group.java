package com.albin.universitySystem.Entitites;

import com.albin.universitySystem.Enums.Semester;
import jakarta.persistence.*;

public class Group {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    long id;
    Profesor professor;
    Componente componente;
    @Enumerated(EnumType.STRING)
    Semester semester;
}
