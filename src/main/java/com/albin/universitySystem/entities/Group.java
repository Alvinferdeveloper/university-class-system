package com.albin.universitySystem.entities;

import com.albin.universitySystem.Enums.Semester;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
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
    @Column(nullable = false)
    Integer year;
}
