package com.example.servicio;

import com.example.dominio.Playlist;

/**
 * Created by rodrigo on 18/06/16.
 */
public interface PlaylistService {
    void agregarPlaylist(Integer idUsuario, String titulo);
    void agregarPlaylist(Playlist playlist);
    void eliminarPlaylist(Integer idPlaylist);
    void agregarCancionEnPlaylist(Integer idPlaylist, Integer idCancion);
    void eliminarCancionEnPlaylist(Integer idPlaylist, Integer idCancion);
    Playlist verPlaylist(Integer idPlaylist);
}
