package com.albin.universitySystem.Entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Alumno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;
    @Column(nullable = false)
    String name;
    String lastName;
    @Column(nullable = false)
    String email;
    String phone;
    Date birthDate;
    String dni;
}
