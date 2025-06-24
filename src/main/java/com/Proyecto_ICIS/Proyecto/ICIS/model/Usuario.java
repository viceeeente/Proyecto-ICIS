package com.Proyecto_ICIS.Proyecto.ICIS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String run;

    @Column(nullable = false)
    private String dv;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String segundoNombre;

    @Column(nullable = false)
    private String apellidoPaterno;

    @Column(nullable = false)
    private String apellidoMaterno;

    @Column(nullable = false)
    private String claveUnica;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nacionalidad;
}
