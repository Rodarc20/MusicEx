package com.example.servicio;

/**
 * Created by rodrigo on 17/06/16.
 */

public interface CancionService {
    void agregarCancion(Integer id_album, String titulo, String path, Integer numero, Integer duracion);//implica crear cancion
    void eliminarCancion(Integer id_cancion);
    void incrementarSeguidores(Integer id_cancion);//el incremento siempre es de 1
    void calcularPuntuacion(Integer id_cancion);
}
