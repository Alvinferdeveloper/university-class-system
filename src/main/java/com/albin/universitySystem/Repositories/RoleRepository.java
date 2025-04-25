package com.albin.universitySystem.Repositories;

import com.albin.universitySystem.Entitites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
