package com.albin.universitySystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Authority {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private com.albin.universitySystem.Enums.Authority authority;
    @ManyToMany(mappedBy = "authorities")
    private List<Role>  roles;
    @ManyToMany(mappedBy = "authorities")
    private List<Profesor> profesors;
}

