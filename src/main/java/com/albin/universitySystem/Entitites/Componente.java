package com.albin.universitySystem.Entitites;

import com.albin.universitySystem.Enums.Semester;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Componente {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;
    @Column(unique=true, nullable = false)
    String name;
    int owner_year;
    @ManyToMany(mappedBy = "componentes", fetch = FetchType.EAGER)
    List<Alumno> alumnos;
    @ManyToOne
    @JoinColumn(name="profesor_id")
    Profesor profesor;
    @Enumerated(EnumType.STRING)
    Semester semester;
}
