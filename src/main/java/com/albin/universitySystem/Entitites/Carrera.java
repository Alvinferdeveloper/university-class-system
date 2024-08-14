package com.albin.universitySystem.Entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToMany(mappedBy = "carreras")
    List<Profesor> profesores;

}
