package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/register")
    public String mostrarRegistro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "/login";
    }



}