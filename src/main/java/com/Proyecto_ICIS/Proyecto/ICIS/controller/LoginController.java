package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombre,
                                @RequestParam String password,
                                Model model) {
        Optional<Usuario> usuario = usuarioService.autenticar(nombre, password);

        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "bienvenido";
        } else {
            model.addAttribute("error", "Nombre o contraseña incorrectos");
            return "login";
        }
    }
}