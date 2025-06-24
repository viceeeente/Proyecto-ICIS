package com.Proyecto_ICIS.Proyecto.ICIS.service;

import com.Proyecto_ICIS.Proyecto.ICIS.model.Usuario;
import com.Proyecto_ICIS.Proyecto.ICIS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> autenticarLogin(String nombre, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByNombre(nombre);

        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario;
        }

        return Optional.empty();
    }

    public Optional<Usuario> autenticarLoginTramite(String nombre, String claveUnica) {
        Optional<Usuario> usuario = usuarioRepository.findByNombre(nombre);

        if(usuario.isPresent()){
            Usuario u = usuario.get();
            if(u.getClaveUnica().equals(claveUnica)) {
                return usuario;
            }
        }
        return Optional.empty();
    }
}