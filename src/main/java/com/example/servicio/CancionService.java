package com.example.servicio;

/**
 * Created by rodrigo on 17/06/16.
 */

public interface CancionService {
    void agregarCancion(Integer id_album, String titulo, String path, Integer numero, Integer duracion);
    void eliminarCancion(Integer id_cancion);
}
