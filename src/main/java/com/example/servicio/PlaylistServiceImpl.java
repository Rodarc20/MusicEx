package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.PlaylistRepositorio;
import com.example.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PlaylistServiceImpl implements PlaylistService{
    PlaylistRepositorio playlistRepositorio;
    CancionRepositorio cancionRepositorio;
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public PlaylistServiceImpl (PlaylistRepositorio pr, CancionRepositorio cr, UsuarioRepositorio ur){
        playlistRepositorio = pr;
        cancionRepositorio = cr;
        usuarioRepositorio = ur;
    }

    @Transactional
    @Override
    public void agregarPlaylist(Integer id_usuario, String titulo){
        Playlist playlist = new Playlist();
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        playlist.setUsuario(usuario);
        playlist.setTitulo(titulo);
        playlist.setFecha(new Date());
        playlist.setPuntuacion(0);
        playlist.setSeguidores(0);
        playlistRepositorio.save(playlist);
    }

    @Override
    public void eliminarPlaylist(Integer id_playlist){
        playlistRepositorio.delete(id_playlist);
    }

    @Transactional
    @Override
    public void agregarCancionEnPlaylist(Integer id_playlist, Integer id_cancion){
        Playlist playlist = playlistRepositorio.findOne(id_playlist);
        Cancion cancion = cancionRepositorio.findOne(id_cancion);
        playlist.addCancion(cancion);
    }

}
