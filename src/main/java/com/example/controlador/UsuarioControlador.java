package com.example.controlador;

/**
 * Created by rodrigo on 01/07/16.
 */
import java.util.List;

import com.example.dominio.Usuario;
import com.example.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControlador {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PlaylistService playlistService;
    @Autowired
    PuntuacionService puntuacionService;
    @Autowired
    SeguimientoService seguimientoService;
    @Autowired
    CancionService cancionService;

    @RequestMapping(value = "/usuarioSigue", method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> usuarioSigue (Usuario usuario){
        return seguimientoService.usuariosSeguidos(usuario.getId_usuario());
    }//debo recibir al usuario del cual quiero conseguir a los que este sigue
}
