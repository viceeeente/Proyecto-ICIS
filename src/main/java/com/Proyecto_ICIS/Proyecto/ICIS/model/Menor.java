package com.Proyecto_ICIS.Proyecto.ICIS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="menor")
public class Menor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String segundoNombre;

    @Column (nullable = false)
    private String apellidoPaterno;

    @Column (nullable = false)
    private String apellidoMaterno;

    @Column (nullable = false)
    private String run;

    @Column (nullable = false)
    private String dv;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Parentesco tipoParentesco;

    @OneToOne
    private TramiteFormularioSalidaOIngreso tramite;

}
