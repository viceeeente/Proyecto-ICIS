package com.Proyecto_ICIS.Proyecto.ICIS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String nacionalidad;

    @Column (nullable = false)
    private Date fechaSalida;

    @Column (nullable = false)
    private Date fechaIngreso;

    @Column (nullable = false)
    private Boolean vehiculoPropio;

    @Column (nullable = false)
    private Boolean viajaConMenor;

    @ManyToOne
    private Usuario usuario;

}
