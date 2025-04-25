package com.albin.universitySystem.Entitites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(name = "role_autoritie", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "autoritie_id")
    )
    private List<Autoritie> autorities;
    @OneToMany(mappedBy = "role")
    private List<Profesor> profesores;
}
