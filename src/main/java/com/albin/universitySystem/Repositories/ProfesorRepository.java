package com.albin.universitySystem.Repositories;

import com.albin.universitySystem.Entitites.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Boolean existsByEmail(String email);
}
