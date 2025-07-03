package com.albin.universitySystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    String name;
    String lastName;
    @Column(nullable = false, length = 50)
    String email;

    @Column(nullable = false)
    String password;
    String phone;
    @Column(nullable = false)
    Date birthDate;
    String dni;
    @ManyToMany
    @JoinTable(name = "profesor_authority", joinColumns = @JoinColumn(name = "profesor_id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id"))
    List<Authority> authorities;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
    @ManyToMany
    @JoinTable( name = "profesor_carrera", joinColumns = @JoinColumn(name = "profesor_id"),
    inverseJoinColumns = @JoinColumn(name = "carrera_id"))
    List<Carrera> carreras;
    @OneToMany(mappedBy = "profesor")
    List<Group> groups;


}
