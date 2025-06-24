package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/bienvenida")
    public String mostratBienvenida(){
        return "bienvenida";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/home")
    public String mostratHome(Model model) {
        return "home";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombre,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

        Optional<Usuario> usuarioOpt = usuarioService.autenticarLogin(nombre, password);

        if(usuarioOpt.isPresent()) {
            session.setAttribute("usuarioLogeado",usuarioOpt.get());
            System.out.println("Guardado en sesion: " + usuarioOpt.get().getNombre());
            return "redirect:/home";
        } else {
            model.addAttribute("errorLogin", "Nombre o contraseña incorrectos");
            return "login";
        }
    }
}