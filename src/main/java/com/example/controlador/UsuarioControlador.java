package com.example.controlador;

/**
 * Created by rodrigo on 01/07/16.
 */
import java.util.List;

import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ComentarioService comentarioService;

    @RequestMapping(value = "/usuarioSigue", method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> usuarioSigue (Usuario usuario){
        return seguimientoService.usuariosSeguidos(usuario.getIdUsuario());
    }//debo recibir al usuario del cual quiero conseguir a los que este sigue

    @RequestMapping(value = "/usuario/{idUsuario}/crearPlaylist", method = RequestMethod.POST)
    @ResponseBody
    public Playlist crearPlaylist (@PathVariable(value = "idUsuario") Integer idUsuario, Playlist playlist){//lapregunta es si sabra discriminar correctamente
        Usuario usuario = usuarioService.verUsuario(idUsuario);
        playlist.setUsuario(usuario);
        playlistService.agregarPlaylist(playlist);
        return playlist;
    }

    @RequestMapping(value = "/playlists/{idPlaylist}", method = RequestMethod.GET)//quiza la url de la playlist tambien deba tener la informaion dl ususario al que le perteneces
    @ResponseBody
    public Playlist verPlaylist(@PathVariable(value = "idPlaylist") Integer idPlaylist){
        return playlistService.verPlaylist(idPlaylist);
    }
}
