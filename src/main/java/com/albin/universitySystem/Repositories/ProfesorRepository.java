package com.albin.universitySystem.Repositories;

import com.albin.universitySystem.entities.Profesor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Boolean existsByEmail(String email);
    @EntityGraph(attributePaths = {"authorities","role"})
    Optional<Profesor> findByEmail(String email);
}
