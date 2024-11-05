package com.albin.universitySystem.Entitites;

import com.albin.universitySystem.Enums.Semester;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "class_group")
public class Group {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    @ManyToOne
    @JoinColumn(name = "componente_id")
    Componente componente;
    @Enumerated(EnumType.STRING)
    Semester semester;
}
