package com.albin.dbrelations.Entitites;

import com.albin.dbrelations.Enums.Autoritie;
import com.albin.dbrelations.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    long id;
    @Column(nullable = false, length = 50)
    String name;
    String lastName;
    @Column(nullable = false, length = 50)
    String email;
    String phone;
    @Column(nullable = false)
    Date birthDate;
    String dni;
    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    List<Componente> componentes;
    @Enumerated(EnumType.STRING)
    Autoritie autoritie;
    @Enumerated(EnumType.STRING)
    Role role;
    @ManyToMany
    @JoinTable( name = "profesor_carrera", joinColumns = @JoinColumn(name = "profesor_id"),
    inverseJoinColumns = @JoinColumn(name = "carrera_id"))
    List<Carrera> carreras;


}
