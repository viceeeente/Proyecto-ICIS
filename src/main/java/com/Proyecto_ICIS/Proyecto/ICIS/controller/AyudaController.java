package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AyudaController {

    @GetMapping("/centro-ayuda")
    private String mostrarCentroAyuda() {
        return "centro-ayuda";
    }
}
