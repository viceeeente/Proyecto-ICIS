package com.Proyecto_ICIS.Proyecto.ICIS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="formularioSalida-Ingreso")
public class TramiteFormularioSalidaOIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String run;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String claveUnica;

    @Column (nullable = false)
    private String nacionalidad;

    @Column (nullable = false)
    private LocalDate fechaSalida;

    @Column (nullable = false)
    private LocalDate fechaIngreso;

    @Column (nullable = false)
    private Boolean vehiculoPropio;

    @Column (nullable = false)
    private Boolean viajaConMenor;

    @ManyToOne
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehiculo vehiculo;

    @OneToOne(cascade = CascadeType.ALL)
    private Menor menor;

}