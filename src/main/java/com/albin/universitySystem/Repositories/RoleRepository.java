package com.albin.universitySystem.Repositories;

import com.albin.universitySystem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
