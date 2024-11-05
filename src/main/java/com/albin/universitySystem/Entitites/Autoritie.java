package com.albin.universitySystem.Entitites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Autoritie {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private com.albin.universitySystem.Enums.Autoritie autoritie;
    @ManyToMany(mappedBy = "autorities")
    private List<Role>  roles;
    @ManyToMany(mappedBy = "autorities")
    private List<Profesor> profesors;
}

