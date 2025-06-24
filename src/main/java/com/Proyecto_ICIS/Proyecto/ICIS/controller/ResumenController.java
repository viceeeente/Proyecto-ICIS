package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.TramiteFormularioSalidaOIngreso;
import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.repository.TramiteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ResumenController {

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/resumen-tramite/{id}")
    public String mostrarResumen(@PathVariable("id") Long id, Model model, HttpSession session) {
        Usuario usuarioSession = (Usuario) session.getAttribute("usuarioLogeado");
        if(usuarioSession == null) {
            return "redirect:/login-tramite?error=acceso";
        }
        Optional<TramiteFormularioSalidaOIngreso> tramiteOpt = tramiteRepository.findById(id);
        if(!tramiteOpt.isPresent()) {
            return "redirect:/tramite?error=noEncontrado";
        }
        TramiteFormularioSalidaOIngreso tramite = tramiteOpt.get();
        if(!tramite.getUsuario().getId().equals(usuarioSession.getId())) {
            return "redirect:/tramite?error=accesoNoAutorizado";
        }
        model.addAttribute("tramite",tramite);
        return "resumen-tramite";
    }

}