package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
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
                                       HttpSession session,
                                       Model model) {
        Optional<Usuario> usuario = usuarioService.autenticarLoginTramite(nombre,claveUnica);

        if(usuario.isPresent()) {
            session.setAttribute("usuario", usuario.get());
            return "redirect:/tramite";
        } else {
            model.addAttribute("errorTramiteFormulario","Nombre o Clave Unica incorrectos");
            return "login-tramite";

        }
    }

}