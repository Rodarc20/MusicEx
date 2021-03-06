package com.example.servicio;

/**
 * Created by rodrigo on 30/06/16.
 */
public interface PuntuacionService {
    void agregarPuntuacion(Integer idUsuario, Integer idCancion, Integer puntuacion);//si la puntuacion existe no debo agregar otra
    void eliminarPuntuacion(Integer idPuntuacion);//por ejemplo si la puntuacion es 0, debo eliminarla, aun que deberia existir el valor, 0, es decir me parece mediocre
    void modificarPuntuacion(Integer idPuntuacion, Integer newPuntuacion);//aun que temabien podria llegar a la puntuacion a travez del id
}
