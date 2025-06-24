package com.Proyecto_ICIS.Proyecto.ICIS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="alimento")
public class Alimento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double kilogramos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAlimento tipoAlimento;

    @OneToOne
    private TramiteFormularioSalidaOIngreso tramite;
}