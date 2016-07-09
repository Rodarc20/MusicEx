package com.example.servicio;

import com.example.dominio.Cancion;

import java.util.List;

/**
 * Created by rodrigo on 17/06/16.
 */

public interface CancionService {
    void agregarCancion(Integer idAlbum, String titulo, String path, Integer numero, Integer duracion);//implica crear cancion
    void eliminarCancion(Integer idCancion);
    void incrementarSeguidores(Integer idCancion);//el incremento siempre es de 1
    void calcularPuntuacion(Integer idCancion);
    List<Cancion> canciones();
}
