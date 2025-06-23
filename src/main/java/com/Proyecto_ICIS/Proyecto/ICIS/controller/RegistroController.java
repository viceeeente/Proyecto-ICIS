package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import ch.qos.logback.core.model.Model;
import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarRegistro(){
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario, Model model) {
        usuarioService.guardar(usuario);
        return "/login";
    }

}