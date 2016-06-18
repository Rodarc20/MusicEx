package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
public interface PlaylistService {
    void agregarPlaylist(Integer id_usuario, String titulo);
    void eliminarPlaylist(Integer id_playlist);
    void agregarCancionEnPlaylist(Integer id_playlist, Integer id_cancion);
    void eliminarCancionEnPlaylist(Integer id_playlist, Integer id_cancion);
}
