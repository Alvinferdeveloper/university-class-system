package com.albin.universitySystem.Repositories;

import com.albin.universitySystem.Entitites.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
