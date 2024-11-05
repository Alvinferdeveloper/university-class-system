package com.albin.universitySystem.Entitites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    private long id;
    @ManyToMany
    @JoinTable(name = "role_autoritie", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "autoritie_id")
    )
    private List<Autoritie> autorities;
    @OneToMany(mappedBy = "role")
    private List<Profesor> profesores;
}
