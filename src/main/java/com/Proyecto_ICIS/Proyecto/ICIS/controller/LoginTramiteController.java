package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class LoginTramiteController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login-tramite")
    public String mostrarLoginTramite() {
        return "login-tramite";
    }

    @PostMapping("/login-tramite")
    public String procesarLoginTramite(@RequestParam String nombre,
                                       @RequestParam String claveUnica,
                                       Model model) {
        Optional<Usuario> usuario = usuarioService.autenticarLoginTramite(nombre,claveUnica);

        if(usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "redirect:/tramite";
        } else {
            model.addAttribute("error","Nombre o Clave Unica incorrectos");
            return "login-tramite";

        }
    }
}
