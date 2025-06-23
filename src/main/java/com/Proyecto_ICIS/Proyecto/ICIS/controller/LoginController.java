package com.Proyecto_ICIS.Proyecto.ICIS.controller;


import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Proyecto_ICIS.Proyecto.ICIS.repository.UsuarioRepository;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombre,
                                @RequestParam String password,
                                Model model) {
        Optional<Usuario> usuario = usuarioRepository.findByNombre(nombre);
        if(usuario.isPresent()) {
            Usuario u = usuario.get();
            if(u.getPassword()!= null && u.getPassword().equals(password)) {
                model.addAttribute("usuario",u);
                return "bienvenido";
            }
        }
        model.addAttribute("error","Nombre o contraseña incorrectos");
        return "login";
    }
}

