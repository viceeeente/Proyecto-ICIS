package com.Proyecto_ICIS.Proyecto.ICIS.controller;

import com.Proyecto_ICIS.Proyecto.ICIS.model.*;
import com.Proyecto_ICIS.Proyecto.ICIS.repository.TramiteRepository;
import com.Proyecto_ICIS.Proyecto.ICIS.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class TramiteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/tramite")
    public String mostratLoginTramite(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");
        System.out.println("Usuario en sesion: " + usuario);
        System.out.println("ID de sesion: " + session.getId());


        TramiteFormularioSalidaOIngreso formulario = new TramiteFormularioSalidaOIngreso();
        formulario.setRun(usuario.getRun());
        formulario.setNombre(usuario.getNombre());
        formulario.setClaveUnica(usuario.getClaveUnica());
        formulario.setNacionalidad(usuario.getNacionalidad());
        formulario.setUsuario(usuario);
        formulario.setVehiculo(new Vehiculo());
        formulario.setMenor(new Menor());
        formulario.setAlimento(new Alimento());

        model.addAttribute("tramiteFormularioSalidaOIngreso",formulario);
        return "tramite";
    }

    @PostMapping("/tramite")
    public String procesarFormulario(
            @ModelAttribute("tramiteFormularioSalidaOIngreso") TramiteFormularioSalidaOIngreso formulario,
            BindingResult result,
            Model model,
            HttpSession session) {

        System.out.println("📥 POST recibido con datos:");
        System.out.println(formulario);

        if (result.hasErrors()) {
            System.out.println("❌ Errores de binding:");
            result.getAllErrors().forEach(e -> System.out.println("• " + e));
            return "tramite";
        }

        Usuario usuarioSesion = (Usuario) session.getAttribute("usuarioLogeado");

        if(usuarioSesion != null && usuarioSesion.getId() != null) {
            Usuario usuarioPersistido = usuarioService.buscarPorNombre(usuarioSesion.getNombre());
            formulario.setUsuario(usuarioPersistido);
        }else {
            System.out.println("Usuario no encontrado en sesion");
            return "redirect:/login-tramite?error=acceso";
        }
        try {
            TramiteFormularioSalidaOIngreso tramiteGuardado = tramiteRepository.save(formulario);
            System.out.println("Tramite guardado");
            return "redirect:/resumen-tramite/" + tramiteGuardado.getId();
        }   catch (Exception e ) {
            return "redirect:/home";
        }
    }



}