package com.albin.dbrelations.Entitites;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Group {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    long id;
    Profesor professor;
    Componente componente;
}
