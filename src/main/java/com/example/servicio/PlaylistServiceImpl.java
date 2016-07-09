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
    public void agregarPlaylist(Integer idUsuario, String titulo){
        Playlist playlist = new Playlist();
        Usuario usuario = usuarioRepositorio.findOne(idUsuario);
        playlist.setUsuario(usuario);
        playlist.setTitulo(titulo);
        playlist.setFecha(new Date());
        playlist.setPuntuacion(0);
        playlist.setSeguidores(0);
        playlistRepositorio.save(playlist);
    }

    @Transactional
    @Override
    public void agregarPlaylist(Playlist playlist){
        playlistRepositorio.save(playlist);
    }
    @Override
    public void eliminarPlaylist(Integer idPlaylist){
        playlistRepositorio.delete(idPlaylist);
    }

    @Transactional
    @Override
    public void agregarCancionEnPlaylist(Integer idPlaylist, Integer idCancion){
        Playlist playlist = playlistRepositorio.findOne(idPlaylist);
        Cancion cancion = cancionRepositorio.findOne(idCancion);
        playlist.addCancion(cancion);
    }

    @Override
    public void eliminarCancionEnPlaylist(Integer idPlaylist, Integer idCancion){
        Playlist playlist = playlistRepositorio.findOne(idPlaylist);
        Cancion cancion = cancionRepositorio.findOne(idCancion);
        playlist.deleteCancion(cancion);
    }

    @Override
    public Playlist verPlaylist(Integer idPaylist){
        return playlistRepositorio.findOne(idPaylist);
    }
}
